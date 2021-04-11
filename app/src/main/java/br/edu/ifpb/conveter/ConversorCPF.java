package br.edu.ifpb.conveter;

import br.edu.ifpb.model.CPF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "conversor.cpf", forClass = CPF.class)
public class ConversorCPF implements Converter {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if(value == null){
                return null;
            }
            CPF cpf = new CPF(value);
            return cpf;
        }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value == null){
            return null;
        }
        CPF cpf = (CPF) value;
        return cpf.valor();
    }

}
