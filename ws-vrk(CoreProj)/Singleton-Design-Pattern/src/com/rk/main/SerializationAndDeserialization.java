package com.rk.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationAndDeserialization {
	
	public static void getSerialization(Pen p) throws Exception {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\src.sr"));
		oos.writeObject(p);
		oos.close();
	}

	public static Pen getDeserialization() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\src.sr"));

		return (Pen) ois.readObject();
	}
}
