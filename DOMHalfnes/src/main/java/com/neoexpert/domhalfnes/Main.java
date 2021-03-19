package com.neoexpert.domhalfnes;
import com.cupvm.jsjvm.JVMServer;
import js.dom.*;

public class Main{
	public static void main(String[] args)throws Throwable{
		/*
		if(!DOM.isInitialized()){
			//DOM is not initialized
			JVMServer.startThisJar(args);
			return;
		}
		else 
		*/
		DOMNES.main(args);
	}
        
}
