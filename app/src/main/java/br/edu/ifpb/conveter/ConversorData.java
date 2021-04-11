package br.edu.ifpb.conveter;


import br.edu.ifpb.model.CPF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FacesConverter(value = "conversor.data")
public class ConversorData implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        return LocalDate.of(Integer.parseInt(value.substring(6,10)),
                Integer.parseInt(value.substring(3,5)), Integer.parseInt(value.substring(0,2)));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        LocalDate data = (LocalDate) value;

        if(value == null){
            return null;
        }
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


    }
}
