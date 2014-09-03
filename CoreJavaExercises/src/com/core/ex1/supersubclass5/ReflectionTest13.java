/**
 * 
 */
package com.core.ex1.supersubclass5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * This is a reflection test
 * @version 123
 * @author icastillejos
 */
public class ReflectionTest13 {
	public static void main(String[] args){
		//Read class name from command line
		String className;
		if (args.length > 0){
			className = args[0];
		} else {
			Scanner in = new Scanner(System.in);
			out.println("Enter class name (e.g. java.util.Date): ");
			className = in.next();			
		}
		
		try{
			//print class and superclass name
			Class cl = Class.forName(className);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			
			System.out.println("class" + className);
			
			if (supercl != null && supercl != Object.class)
			{		
				out.print(" extends " +  supercl.getName());
			}
			out.print("\n{\n");
			printConstructors(cl);
			out.println();
			printMethods(cl);
			printFields(cl);
			out.println("}");		
		} 
		catch (Exception e){
			
		}		
	}




	/**
	 * Print costructors
	 * @param cl
	 */
	private static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getConstructors();
		out.println("### Constructors ###");
		for (Constructor c: constructors){
			String name = c.getName();
			out.print("    ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length()>0){
				out.print(modifiers + " ");
			}
			out.print(name + "(");
			
			/**
			 * Print parameters
			 */
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j <paramTypes.length; j++){
				if (j>0){
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * Print all methods of a class
	 * @param cl
	 */
	private static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods){
			Class retType = m.getReturnType();
			String name = m.getName();
			
			out.print("    ");
			//print modifiers, return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0 ){
				out.print(modifiers+"");
			}
			System.out.print(retType.getName() + " " + name + "(");
			//print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++){
				if (j>0){
					System.out.print(paramTypes[j].getName());
				}
			}
			System.out.println(");");
		}
		
	}

	/**
	 * Print all class fields
	 * @param cl
	 */
	private static void printFields(Class cl) {
		Field[] fields = cl.getFields();
		for (Field f :fields){
			Class type = f.getType();
			String name = f.getName();
			out.print("    ");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length()>0){
				out.print(modifiers+" ");
			}
			out.println(type.getName() + " " + name + ";");
		}
	}
}
