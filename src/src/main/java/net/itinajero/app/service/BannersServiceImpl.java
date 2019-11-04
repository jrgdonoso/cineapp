package net.itinajero.app.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista; 
	
	public BannersServiceImpl() {
		
		System.out.println("Banner creado....");
		SimpleDateFormat formatear = new SimpleDateFormat("dd-mm-yyyy");
		this.lista=new LinkedList<>();//Ojo con la utilizacion de linkedList
		
		
		Banner miBanner;
		for( int i=0;i<9;i++  ) {
			
			try {
			 miBanner=new Banner();
			
			miBanner.setTitulo("titulo "+i);
			miBanner.setId(i);
			miBanner.setFecha( formatear.parse("30-07-2019"));
			if(i>6) {
				miBanner.setEstatus("Inactivo");
			}else {
			miBanner.setEstatus("Activo");
			}
			miBanner.setArchivo("cine.png");
			
			System.out.println("Banner creado= "+miBanner.toString());
			this.lista.add(miBanner);
			
			
			} catch (ParseException e) {
				System.out.println("Error : " + e.getMessage());
			}
			
		}
	}

	@Override
	public void insertar(Banner banner) {
		
		this.lista.add(banner);
		
	}

	
	@Override
	public List<Banner> buscarTodos() {
		
		return this.lista;
		
	}


}
