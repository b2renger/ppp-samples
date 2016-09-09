package net.mgsx.ppp.samples.loopersynth;

import net.mgsx.ppp.view.PdDroidPatchView;
import net.mgsx.ppp.widget.core.Toggle;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;


/**
 * Toggle with plain button.
 */
public class HexToggle extends Toggle
{
	protected float cursorX, px;
	protected int pid = -1;
	private Path hexagonPath;
	//private ShapeDrawable d;
	int nbgcolor, nfgcolor , nlabelcolor;

	public HexToggle(PdDroidPatchView app, String[] atomline) {
		super(app, atomline);
		dRect.bottom = dRect.top + dRect.width();
		hexagonPath = new Path();
		 hexagonPath.moveTo(dRect.left + dRect.width()/4, dRect.top);
		 hexagonPath.lineTo(dRect.right - dRect.width()/4, dRect.top);
		 hexagonPath.lineTo(dRect.right , dRect.top + dRect.height()/2);
		 hexagonPath.lineTo(dRect.right - dRect.width()/4, dRect.bottom);
		 hexagonPath.lineTo(dRect.left + dRect.width()/4, dRect.bottom);
		 hexagonPath.lineTo(dRect.left, dRect.bottom-dRect.height()/2);
		 hexagonPath.lineTo(dRect.left + dRect.width()/4, dRect.top);
		 hexagonPath.moveTo(dRect.left + dRect.width()/4, dRect.top);
		 
		// Shape s = new PathShape(hexagonPath, dRect.width(), dRect.height());
		 //ShapeDrawable d = new ShapeDrawable(s);
		 
		 if(atomline[9].length() == 3){
			 nbgcolor = 0xFF765A33;
			 nfgcolor = 0xFFFBCB4B;
			 nlabelcolor = 0xFFFFF7D2;	
		 }
		 else if (atomline[9].length() > 3){
			 nbgcolor = 0xFF765A33;
			 nfgcolor = 0xFFFBCB4B;
			 nlabelcolor = 0xFFFBCB4B;	
		 }
		 else {
			 nbgcolor = 0xFF333220;
			 nfgcolor = 0xFFFBCB4B;
			 nlabelcolor = 0xFFFFF7D2;
		 }
		
	}
	
	@Override
	public void draw(Canvas canvas) 
	{
		
		paint.setColor(nbgcolor);
		paint.setStyle(Paint.Style.FILL);
		paint.setStrokeCap(Cap.ROUND);
		canvas.drawPath(hexagonPath, paint);
		
		//canvas.drawPaint(paint);
		
		paint.setColor(nfgcolor);
		paint.setStrokeWidth(4);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(hexagonPath, paint);
		
		
		if (val != 0) {
			
				paint.setColor(nfgcolor);
				paint.setStyle(Paint.Style.FILL);
				canvas.drawPath(hexagonPath, paint);
				
		}
		if (label != null) {
			paint.setStyle(Paint.Style.FILL);
			paint.setTextAlign(Align.LEFT);
			paint.setStrokeWidth(0);
			paint.setColor(nlabelcolor);
			paint.setTextSize(labelsize);
			paint.setTypeface(font);
			// convert from middle-left to baseline-left
			canvas.drawText(label, dRect.left + labelpos[0], dRect.top + labelpos[1] - paint.ascent() + paint.getFontMetrics().top/2, paint);
	
		}
	}
	

}
