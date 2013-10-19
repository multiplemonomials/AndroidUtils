package com.multiplemonomials.androidutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class LineReader 
{
	
	InputStream    		_inputStream;
	BufferedReader 		_bufferedReader;
	//String         	justReadLine;
	int 				_currentLine;
	
	// Ctor.
	public LineReader(File file) throws FileNotFoundException
	{
		// Try opening the file.
		try 
		{
			_inputStream = new FileInputStream(file.getName());
		} 
		catch (FileNotFoundException exceptionName) 
		{
			// TODO Auto-generated catch block
			exceptionName.printStackTrace();
			throw exceptionName;
		}
		
		
		// Open a buffered reader on the file.
		_bufferedReader = new BufferedReader(new InputStreamReader(_inputStream, Charset.forName("UTF-8")));
		
		
		// Start out on the first line.
		_currentLine = 0;
	}
	
	public LineReader(InputStream inputStream)
	{
		_inputStream = inputStream;
		_bufferedReader = new BufferedReader(new InputStreamReader(_inputStream, Charset.forName("UTF-8")));
		_currentLine = 0;
	}
	
	
	/**
	 * Returns the next line of the current file.  Returns null on end of file.
	 * Throws on error.
	 * @return 
	 * @throws IOException 
	 */
	public String readNextLine() throws IOException
	{
		// Indicate we've read one more line.
		_currentLine++;
		
		
		// Return next file line if possible (throws on error).
		return _bufferedReader.readLine();
	}
	
	
	/**
	 * Skips the linereader to a line.
	 * @param linethe line to skip to.  should NEVER be less than the current line
	 * @throws IOException 
	 */
	public void skipToLine(int line) throws IOException
	{
		if(line > _currentLine)
		{
			for( ; line < _currentLine ; line++)
			{
				readNextLine();
			}
		}
		
		else if(line == _currentLine)
		{
			return;
		}
		
		else if(line < _currentLine)
		{
			//uh-oh
			//this should never happen
			
			assert(false);
		}
	}
	

}
