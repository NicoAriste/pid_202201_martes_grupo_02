package com.proyecto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.entity.Usuario;
import com.proyecto.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService servicio;

	@RequestMapping("/login")
	public String login(Usuario user, HttpSession session, HttpServletRequest request) {
		Usuario usuario = servicio.login(user);
		if (usuario == null) {
			request.setAttribute("mensaje", "El usuario no existe");
			return "sistemaLogin";
		} else {
			session.setAttribute("objUsuario", usuario);
			//session.setAttribute("objMenus", menus);
			//session.setAttribute("objRoles", roles);

			return "sistemaInicio";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();

		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("mensaje", "El usuario salió de sesión");
		return "sistemaLogin";

	}

}
