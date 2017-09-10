package com.geekz.pos.hardware;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import org.apache.log4j.Logger;

import com.geekz.orm.ORMFactory;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

public class BarcodePrinter {

	final static Logger logger = Logger.getLogger(BarcodePrinter.class);

	public void generateBarcode() {

	}

	public void printBarcode(String barcodeValue) throws BarcodeException {
		logger.info("print barcode for - " + barcodeValue);
		Barcode b = BarcodeFactory.createCodabar(barcodeValue);
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(b);
		if (job.printDialog()) {
			try {
				job.print();
				logger.info("barcode is printed");
			} catch (PrinterException e) {
				logger.error(e);
			}
		}

	}
}
