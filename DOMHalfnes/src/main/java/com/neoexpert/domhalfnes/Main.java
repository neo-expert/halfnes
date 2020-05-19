package com.neoexpert.domhalfnes;
import js.*;
import js.event.*;
import static js.dom.DOM.*;
import js.dom.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.neoexpert.jsjvm.*;;

public class Main{
	public static void main(String[] args)throws Throwable{
		if(!DOM.isInitialized()){
			//DOM is not initialized
			JVMServer.startThisJar(8080, false);
			return;
		}
		else DOMNES.main(args);
	}
        
}
