/**

TrakEM2 plugin for ImageJ(C).
Copyright (C) 2005, 2006 Albert Cardona and Rodney Douglas.

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation (http://www.gnu.org/licenses/gpl.txt )

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA. 

You may contact Albert Cardona at acardona at ini.phys.ethz.ch
Institute of Neuroinformatics, University of Zurich / ETH, Switzerland.
**/

package ini.trakem2.display;

import ij.gui.*;
import ij.*;
import ini.trakem2.utils.Utils;

import java.awt.Graphics;

/** A class to prevent ROIs from failing. */
public class FakeImageWindow extends ImageWindow {

	private Display display;

	public FakeImageWindow(ImagePlus imp, ImageCanvas ic, Display display) {
		super(imp.getTitle());
		this.display = display;
		ij = IJ.getInstance();
		this.imp = imp;
		this.ic = ic;
		imp.setWindow(this);
		WindowManager.addWindow(this);
	}

	public ImagePlus getImagePlus() {
		ImagePlus last_temp = display.getLastTemp();
		if (null == last_temp) return super.getImagePlus(); // the FakeImagePlus
		return last_temp;
	}

	// just in case .. although it never should be shown
	public void drawInfo(Graphics g) {
		Utils.log("FakeImageWindow: can't drawInfo");
	}

	public void paint(Graphics g) {
		Utils.log("FakeImageWindow: can't paint");
	}

	/* // problematic, ImageJ doesn't quit
	public boolean close() {
		WindowManager.removeWindow(this);
		if (ij.quitting()) return true; // just let go
		if (display.remove(true)) { // check
			display = null;
			return true;
		} else return false;
	}
	*/

	public void updateImage(ImagePlus imp) {
		Utils.log("FakeImageWindow: Can't updateImage");
	}

	public boolean isClosed() {
		return null == display;
	}

	public void paste() {
		Utils.log("FakeImageWindow: can't paste"); // TODO test how
	}
}
