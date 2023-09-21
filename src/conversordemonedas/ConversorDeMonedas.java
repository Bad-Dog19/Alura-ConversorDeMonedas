package conversordemonedas;

import javax.swing.JOptionPane;

public class ConversorDeMonedas {

    public static void main(String[] args) {
        int respuesta;
        do {
            String[] opciones = {
                "Convertir moneda", 
                "Convertir temperatura"
            };

            String seleccion = (String) JOptionPane.showInputDialog(null, 
                    "Elige una opción", 
                    "Conversor", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]);

            if (seleccion.equals("Convertir moneda")) {
                String[] conversormonedas = {
                    "CLP a USD", 
                    "CLP a Euros", 
                    "CLP a Libras Esterlinas",
                    "CLP a Yen Japones", 
                    "CLP a Won Sur-Coreano",
                    "USD a CLP", 
                    "Euros a CLP", 
                    "Libras Esterlinas a CLP",
                    "Yen Japones a CLP", 
                    "Won Sur-Coreano a CLP"
                };

                String seleccionmoneda = (String) JOptionPane.showInputDialog(null,"Elige una opción", "Conversor de Monedas", 
                     JOptionPane.QUESTION_MESSAGE, null, conversormonedas, conversormonedas[0]);
                double cantidad = 0;
                try {
                    cantidad = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad a convertir:"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valor no valido");
                    return;
                }
                double resultado = convertirMoneda(seleccionmoneda, cantidad);

                String monedas = "";
                String moneda = Moneda(seleccionmoneda, monedas);
                JOptionPane.showMessageDialog(null, cantidad + " equivalen a " + resultado + " " + moneda);

            } else if (seleccion.equals("Convertir temperatura")) {

               String[] opcionesTemperatura = {
                   "Celsius a Fahrenheit", 
                   "Celsius a Kelvin",
                   "Fahrenheit a Celsius", 
                   "Fahrenheit a Kelvin",
                   "Kelvin a Celsius", 
                   "Kelvin a Fahrenheit"
               };
               String seleccionTemperatura = (String) JOptionPane.showInputDialog(null, 
                    "Elige una opción", 
                    "Conversor de Temperatura", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opcionesTemperatura, 
                    opcionesTemperatura[0]);

               double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Introduce la temperatura:"));
               double resultado = convertirTemperatura(seleccionTemperatura, temperatura);
               String stringtemp = stringTemperatura(seleccion, temperatura);
               JOptionPane.showMessageDialog(null, "La temperatura convertida es: " + resultado + stringtemp);     
           } else {
               JOptionPane.showMessageDialog(null, "Selección no válida.");
           }

            respuesta = JOptionPane.showConfirmDialog(null, 
                "¿Deseas continuar?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION);
        } while (respuesta == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, "Programa finalizado.");
    }

    public static double convertirMoneda(String seleccion , double cantidad) {
        double tasaCambio = 0;
        switch (seleccion){
             case "CLP a USD":
                 tasaCambio = 0.0011;
                 break;
             case "CLP a Euros":
                 tasaCambio = 0.0011;
                 break;
             case "CLP a Libras Esterlinas":
                 tasaCambio = 0.00091;
                 break;
             case "CLP a Yen Japones":
                 tasaCambio = 0.17;
                 break;
             case "CLP a Won Sur-Coreano":
                 tasaCambio = 1.49;
                 break;
             case "USD a CLP":
                 tasaCambio = 886.62;
                 break;
             case "Euros a CLP":
                 tasaCambio = 947.19;
                 break;
             case "Libras Esterlinas a CLP":
                 tasaCambio = 1097.68;
                 break;
             case "Yen Japones a CLP":
                 tasaCambio = 6;
                 break;
             case "Won Sur-Coreano a CLP":
                 tasaCambio = 0.67;
                 break;
             default:
             JOptionPane.showMessageDialog(null, "Selección no válida.");
                 break;
        }
        return cantidad * tasaCambio;
    }

    public static double convertirTemperatura(String seleccion , double temperatura) {
        double resultado = 0;
        switch (seleccion){
             case "Celsius a Fahrenheit":
                 resultado = temperatura * 9/5 + 32;
                 break;
             case "Celsius a Kelvin":
                 resultado = temperatura + 273.15;
                 break;
             case "Fahrenheit a Celsius":
                 resultado = (temperatura - 32) * 5/9;
                 break;
             case "Fahrenheit a Kelvin":
                 resultado = (temperatura - 32) * 5/9 + 273.15;
                 break;
             case "Kelvin a Celsius":
                 resultado = temperatura - 273.15;
                 break;
             case "Kelvin a Fahrenheit":
                 resultado = (temperatura - 273.15) * 9/5 + 32; 
                 break; 
             default:
             JOptionPane.showMessageDialog(null, "Selección no válida.");
                 break; 
        }
        return resultado; 
    }

    public static String Moneda(String seleccion , String monedas) {
        String monedafinal = "";
        switch (seleccion){
             case "CLP a USD":
                 monedafinal = "USD";
                 break;
             case "CLP a Euros":
                 monedafinal = "Euros";
                 break;
             case "CLP a Libras Esterlinas":
                 monedafinal = "Libras Esterlinas";
                 break;
             case "CLP a Yen Japones":
                 monedafinal = "Yen Japones";
                 break;
             case "CLP a Won Sur-Coreano":
                 monedafinal = "Won Sur-Coreano";
                 break;
             case "USD a CLP":
             case "Euros a CLP":
             case "Libras Esterlinas a CLP":
             case "Yen Japones a CLP":
             case "Won Sur-Coreano a CLP":
                 monedafinal = "CLP";
                 break;
             default:
             JOptionPane.showMessageDialog(null, "Selección no válida.");
                 break;
        }
        return monedafinal;
    }

    public static String stringTemperatura(String seleccion , double temperatura) {
        String stringtemp = "";
        switch (seleccion){
            case "Celsius a Fahrenheit": 
            case "Kelvin a Fahrenheit": 
                stringtemp = "°F";
                break; 
            case "Celsius a Kelvin": 
            case "Fahrenheit a Kelvin": 
                stringtemp = "K";
                break; 
            case "Fahrenheit a Celsius": 
            case "Kelvin a Celsius": 
                stringtemp = "°C";
                break; 
            default:
        }
        return stringtemp; 
    }
}
