/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fernando.tfernandes
 */
public class Validador {
     public ArrayList<String> mensagensErro = new ArrayList<>();
    
    /**
     * Valida somente campos inteiros
     * @param txt Recebe um objeto do tipo JTextField
     */
    public void ValidarNumero(JTextField txt){
    
        try{
            
            //Verifico se o campo está vazio
            if(txt.getText().trim().equals("")){
                throw new IllegalArgumentException();
            }
            
            int valorConvertido = Integer.parseInt(txt.getText());
            txt.setBackground(Color.WHITE);
            
        }catch(NumberFormatException e){
        
            this.mensagensErro.add("não consigo converter esse formato ai não arruma ai " + txt.getName());
            txt.setBackground(Color.red);
        }catch(IllegalArgumentException e){
            this.mensagensErro.add("Digite em formato numerio " + txt.getName());
            txt.setBackground(Color.red);
        }
    
    }
    
    
    public void ValidarTexto(JTextField txt){
    
        try{
            
            //Verifico se o campo está vazio
            if(txt.getText().replace(".", "").replace("-", "").trim().equals("")){
                throw new IllegalArgumentException();
            }
            
            txt.setBackground(Color.white);
            
        }catch(IllegalArgumentException e){
            this.mensagensErro.add("Digite só texto por favor " + txt.getName());
            txt.setBackground(Color.red);
        }
    
    }
    
    
    
    /**
     * Valida somente campos float
     * @param txt Recebe um objeto do tipo JTextField
     */
     public void ValidarFloat(JTextField txt){
     
         try{
            
            //Verifico se o campo está vazio
            if(txt.getText().trim().equals("")){
                throw new IllegalArgumentException();
            }
            
            float valorConvertido = Float.parseFloat(txt.getText());
            txt.setBackground(Color.WHITE);
            
        }catch(NumberFormatException e){
        
            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em float");
            txt.setBackground(Color.red);
        }catch(IllegalArgumentException e){
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName());
            txt.setBackground(Color.red);
        }
     
     }
     
     public void limparMensagens(){
     
         this.mensagensErro.clear();
     }
     
     /**@deprecated substituida por {@link #getMensagensErro()}
      * Método para exibir mensagens de erro na tela com JOptionPane
      */
     public void ExibirMensagensErro(){
         
        String errosFormulario = "";
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }
        
        if(!errosFormulario.equals("")){
            JOptionPane.showMessageDialog(null, errosFormulario);
            this.limparMensagens();
        }     

     }
     
     /**
      * Resgata todos os erros gerados em uma única String
      * @return 
      */
     public String getMensagensErro(){
         
        String errosFormulario = "";
        
        //Percorro o arrayList e concateno na variável errosFormulario
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }
        
        if(!errosFormulario.equals("")){
            this.limparMensagens();
        }     
        
        return errosFormulario;
        
     }
     
     public boolean hasErro(){
     
         if(this.mensagensErro.size()>0){
            return true;    
         }else{
             return false;
         }
     }
     
        /**
     * Valida somente campos Double
     * @param txt Recebe um objeto do tipo JTextField
     * @return 
     */
 public void validarDouble(JTextField txt) {
        try {

            // Verifico se o campo está vazio
            if (txt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }

            double valorConvertido = Double.parseDouble(txt.getText());
            txt.setBackground(Color.WHITE);

        } catch (NumberFormatException e) {

            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em double");
            txt.setBackground(Color.RED);

        } catch (IllegalArgumentException e) {

            this.mensagensErro.add("Digite um valor para o campo " + txt.getName());
            txt.setBackground(Color.RED);

        }
    }
 
}
