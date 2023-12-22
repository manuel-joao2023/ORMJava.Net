/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDJ;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author BRAVANTIC
 */
public class Generater {
    private static StringBuilder conteudo = new StringBuilder();
    
    public static void transformer(Field[] atributos, String classeName){
        Ficheiros files = new Ficheiros();
        conteudo.append("public class ").append(classeName).append(" {\n");
        for(Field y : atributos){
            if (y.getType().equals(String.class) || y.getType().equals(String[].class)) {
                 conteudo.append("\tpublic string ").append(y.getName()).append(" { get; set; }\n");
            }else if(List.class.isAssignableFrom(y.getType())){
                conteudo
                        .append("\tpublic ")
                        .append(y.getType().getSimpleName())
                        .append("<")
                        .append(nameClasseList(y))
                        .append("> ").append(y.getName())
                        .append(" { get; set; }\n");
            }else if(y.getType().isPrimitive()){
                contentPrimitives(y);
            }else{
                conteudo
                        .append("\tpublic ")
                        .append(y.getType().getSimpleName())
                        .append(" ")
                        .append(y.getName())
                        .append(" { get; set; }\n");
                
            }
            
             
        }
        conteudo.append("}\n");
        files.addContentInFile(classeName, conteudo);
        conteudo = new StringBuilder();
    }
    
    private static void contentPrimitives(Field fied){
        switch(fied.getType().getName()){
            case "int":
            case "double":
            case "char":
                conteudo.append("\tpublic ").append(fied.getType()).append(" ").append(fied.getName()).append(" { get; set; }\n");
                break;
            case "boolean":
                conteudo.append("\tpublic ").append("bool").append(" ").append(fied.getName()).append(" { get; set; }\n");
                break;
            default:
                break;
        }
    }
    
    private static String nameClasseList(Field field){
        // Obtenha o tipo genérico do campo
            Type genericType = field.getGenericType();

            if (genericType instanceof ParameterizedType) {
                // Se o tipo genérico for uma instância de ParameterizedType
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                Type[] typeArguments = parameterizedType.getActualTypeArguments();

                if (typeArguments.length > 0 && typeArguments[0] instanceof Class) {
                    Class<?> classeContida = (Class<?>) typeArguments[0];
                    return classeContida.getSimpleName();
                }
            }
            return "";
    }
}
