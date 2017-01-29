/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Persona;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;

@Stateless
public class PersonaService implements PersonaServiceLocal {

    private static ArrayList<Persona> lista = new ArrayList<>();
    private static int lastId = 6;
    
    static{
        lista.add(new Persona(1,"Juan","juan@gmail.com","648594034"));
        lista.add(new Persona(2,"Luis","luis@gmail.com","638429746"));
        lista.add(new Persona(3,"Ana","ana@gmail.com","629573049"));
        lista.add(new Persona(4,"Maria","maria@gmail.com","629586409"));
        lista.add(new Persona(5,"Jose","jose@gmail.com","610495854"));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")  

    @Override
    public ArrayList listPersonas() {
        return lista;
    }

    @Override
    public void addPersona(Persona persona) {
        // Recorremos la lista comprobando que la persona no existe
        Iterator<Persona> it = lista.iterator();
        boolean enc = false;
        
        while((it.hasNext())&&(enc==false)){
            if(it.next().getId()==persona.getId()){
                enc=true;
            }
        }
        // Si la persona no existe la añadimos a la lista
        if(enc==false){
            persona.setId(lastId);
            lastId++;
            lista.add(persona);
        }
    }

    @Override
    public void updatePersona(Persona persona) {
        // Recorremos la lista comprobando que la persona no existe
        boolean enc = false;
        int i=0;
        
        while((i<lista.size())&&(enc==false)){
            if(lista.get(i).getId()==persona.getId()){
                enc=true;                
            }else{
                i++;
            }
        }
        // Si la persona existe, tenemos el indice a modificar 
        // por lo que realizamos la actualizacion
        if(enc==true){
            lista.set(i, persona);
        }        
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        // Recorremos la lista buscando la persona
        Iterator<Persona> it = lista.iterator();
        
        while(it.hasNext()){
            Persona p = it.next();
            if(p.getId()==persona.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public void deletePersona(Persona persona) {
        // Recorremos la lista buscando la persona
        boolean enc = false;
        int i=0;
        
        while((i<lista.size())&&(enc==false)){
            if(lista.get(i).getId()==persona.getId()){
                enc=true;                
            }else{
                i++;
            }
        }
        // Si la persona existe, tenemos el indice borrar
        if(enc==true){
            lista.remove(i);
        }           
    }
    
    
    
}
