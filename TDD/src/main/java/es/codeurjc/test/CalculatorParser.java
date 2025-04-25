package es.codeurjc.test;

public class CalculatorParser {
    public int parse(String expression) {
    	if(expression.matches(".*[A-Za-z]+.*")) throw new NumberFormatException("Invalid expression. Use: Int (+/- Int)*");
    	
    	String[] sums = expression.split("\\+");
    	int res=0;
    	int aux;
    	
    	for(int i=0; i<sums.length; i++) {
    		String[] subs = sums[i].split("-");
   			if(subs[0]=="")aux=0;
   			else aux=Integer.parseInt(subs[0]);
   			
    		for(int j=1; j<subs.length; j++) {
    			aux-=Integer.parseInt(subs[j]);
   			}
   			res+=aux;
   		}
   		return res;
    }
}
