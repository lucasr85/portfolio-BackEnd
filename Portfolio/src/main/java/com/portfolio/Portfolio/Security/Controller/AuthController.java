
package com.portfolio.Portfolio.Security.Controller;

import com.portfolio.Portfolio.Security.Entity.Rol;
import com.portfolio.Portfolio.Security.Entity.Usuario;
import com.portfolio.Portfolio.Security.Enums.RolNombre;
import com.portfolio.Portfolio.Security.Service.RolService;
import com.portfolio.Portfolio.Security.Service.UsuarioService;
import com.portfolio.Portfolio.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas Robles
 */

@RestController
@RequestMapping
@CrossOrigin

public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
   public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindinResult){
       if(bindinResult.hasErrors())
           return new ResponseEntity(new Mensaje("Email invalido o llenó mal los datos"),HttpStatus.BAD_REQUEST);
       
       if(usuarioService.existsByNombreUsuario(nombreUsuario.getNombreUsuario()))
           return new ResponseEntity(new Mensaje("Usuario existente"),HttpStatus.BAD_REQUEST);
       
       if(usuarioService.existsByEmail(nombreUsuario.getEmail))
           return new ResponseEntity(new Mensaje("Email ya registrado"),HttpStatus.BAD_REQUEST);
      
       Usuario usuario = new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getPassword()));
       
       Set<Rol> roles =new HashSet<>();
       roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
       
       if(nuevoUsuario.getRoles().contains("admin"))
           roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
       
       usuario.setRoles(roles);
       usuarioService.save(usuario);
       
       return new ResponseEntity(new Mensaje("Usuario creado"),HttpStatus.CREATED);
   }
    
   @PostMapping("/login")
   public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensaje("Error al completar los datos"),HttpStatus.BAD_REQUEST);
    
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
    
       SecurityContextHolder.getContext().setAuthentication(authentication);
       
       String jwt = jwtProvider.generateToken(authentication);
       
       UserDetails userDetails =(UserDetails) authentication.getPrincipal();
       
       JwtDTO jwtDTO = new jwtDTO(jwt, userDetails.getUsername(),userDetails.getAuthorities());

       return new ResponseEntity(jwtDTO, HttpStatus.OK);
   }
}
