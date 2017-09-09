package com.geekz.pos.hardware;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

public class BarcodePrinter {

	public void generateBarcode() {
		
	}
	
	public void printBarcode(String barcodeValue) throws BarcodeException {
		Barcode b = BarcodeFactory.createCodabar(barcodeValue);
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(b);
		if (job.printDialog())
		{
			try {
				job.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
