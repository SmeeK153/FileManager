package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLConnection;

public class StreamBuffer {
	
	private StreamBuffer(){}
	
	public static void print(InputStream stream){
		try {
			System.out.println(StreamBuffer.read(stream));
		} catch (IOException e) {
			System.err.println("Could not print requested stream, an exception occurred.");
			e.printStackTrace();
		}
	}
	
	public static String read(InputStream stream) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = null;
		String content = "";
		while((line = reader.readLine()) != null){
			content += line;
		}
		return content;
	}
	
	public static void write(OutputStream stream, String content) throws IOException{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
		writer.write(content);
		writer.close();
	}
	
}
