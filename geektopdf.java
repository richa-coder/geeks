/*

	Memory streaming technique is used.
	Ref BCL and net
	Uses: java PrintOut3 <input file name> <output file name>

*/

import com.bcl.easypdf.*;
import com.bcl.easypdf.EasyPDFPrinter.*;
import com.bcl.easypdf.EasyPDFPrinter.IPDFSetting;
import java.io.*;

public class PrintOut3
{
	public static void main(String[] args) throws Exception
	{
		EasyPDF.initialize();

		IPrinter printer = new IPrinter();
		IPrintJob pj = printer.getPrintJob();

		if (args.length == 2)
		{
			File filein = new File(args[0]);
			String strInputFileName = filein.getCanonicalPath();


			File fileout = new File(args[1]);
			String strOutputFileName = fileout.getCanonicalPath();


			FileInputStream fis = new FileInputStream(strInputFileName);
			byte[] byteArr = new byte[(int)filein.length()];
			fis.read(byteArr);

			byte[] byteArrOut = pj.PrintOut3(byteArr, ".txt").toSafeArray().toByteArray();

			FileOutputStream fos = new FileOutputStream(strOutputFileName);
			fos.write(byteArrOut);

			fis.close();	// closing input stream
			fos.close();	// closing output stream
		}
		else
			System.out.println("usage: java PrintOut3 <input filename> <output filename>\n");
		EasyPDF.uninitialize();
	}
}