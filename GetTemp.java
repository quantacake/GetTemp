/* Created by Ted Diepenbrock - CMPS 161
 * 
 * This program generates a random number between ~ -35 and 40 with uneven 
 * probabilities of occurence, and uses the number to represent Fahrenheit/Celsius 
 * and is then used to represent degrees on an ASCII thermometer.
 */

import java.text.MessageFormat;


public class GetTemp {

  public static void main(String[] args) {
    
    convertCelsiusAndDisplay(getCelsius());

  }
  

  /* gets random double between -35C to 40C with 
   uneven probabilities of occurence. */
  static double getCelsius() {
    
    double chance = Math.random();
    int max, min;
    
    if(chance > 0.75) {
      // 25% chance temperature ranging 25 to 40C.
      max=40;
      min=25;
    } else if(chance > 0.25) {
      // 50% chance temperature ranging 0 to 25C.
      max=25;
      min=0;
    } else {
      // 25% chance temperature ranging 0 to -35C.
      max=0;
      min=-35;
    }
    //return Math.round(Math.random()*max);
    return Math.round(Math.random()*(max-min)+min);
  }
 

  // converts celsius to fahrenheit and displays degrees, city and thermometer.
  static void convertCelsiusAndDisplay(double celsius) {

    // cities
    String[] cities = {"Vancouver, Canada", "New Orleans La. USA", "Moscow, Russia", "Oslo, Norweigh", "Seoul, S. Korea", "Athens, Greece", "London, UK", "Paris, FR", "Sidney, AU", "Manilla, Ph"};

    // celsius to fahrenheit formula
    double fahrenheit = (double)9/5 * celsius + 32;

    // ASCII Thermometer
    String meter = MessageFormat.format("     ______________________\r\n     |   ^F     _    ^C   |\r\n     |  100  - |{0}| -  40  |\r\n     |   90  - |{1}| -  30  |\r\n     |   80  - |{2}| -  25  |\r\n     |   70  - |{3}| -  20  |\r\n     |   60  - |{4}| -  15  |\r\n     |   50  - |{5}| -  10  |\r\n     |   40  - |{6}| -   5  |\r\n     |   30  - |{7}| -   0  |\r\n     |   20  - |{8}| -  -5  |\r\n     |   10  - |{9}| - -10  |\r\n     |    0  - |{10}| - -20  |\r\n     |  -10  - |{11}| - -25  |\r\n     |  -20  - |{12}| - -30  |\r\n     |  -30  - |{13}| - -35  |\r\n     |         '***`       |\r\n     |       (*****)      |\r\n     |        `---'        |\r\n     |____________________|\r\n\r\n",((celsius >= 35)?"*":" "), ((celsius >= 30)?"*":" "),  ((celsius >= 25)?"*":" "), ((celsius >= 20)?"*":" "), ((celsius >= 15)?"*":" "), ((celsius >= 10)?"*":" "), ((celsius >= 5)?"*":" "), ((celsius >= 0)?"*":" "), ((celsius >= -5)?"*":" "), ((celsius >= -10)?"*":" "), ((celsius >= -15)?"*":" "), ((celsius >= -20)?"*":" "), ((celsius >= -25)?"*":" "), ((celsius >= -30)?"*":" "));
    
    // Display city, celcius, fahrenheit, and thermometer
    System.out.println("\nCity: " + cities[((int)(Math.random()*cities.length))]);
    System.out.println("\nCelsius: " + Math.round(celsius) + "°C");
    System.out.println("Farenheit: " + Math.round(fahrenheit) + "°F");
    System.out.println(meter);

  }

}


