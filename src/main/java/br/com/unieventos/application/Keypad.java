package br.com.unieventos.application;

import java.util.Scanner;

public class Keypad {
	private Scanner input;

	public Keypad() {
		input = new Scanner(System.in);
	}
	
	public Integer getInputInteiro() {
		return input.nextInt();
	}
	
	public String getInputString() {
		return input.nextLine();
	}
	
	public void pausa() {
		input.nextLine();
	}
		
}
