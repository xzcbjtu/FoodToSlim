package bjtu.edu.cn.foodtoslim.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ChartView extends View{
    public int XPoint=50;    //原点的X坐标
    public int YPoint=260*2;     //原点的Y坐标
    public int XScale=107;     //X的刻度长度
    public int YScale=107;     //Y的刻度长度
    public int XLength=640;        //X轴的长度
    public int YLength=900;        //Y轴的长度
    public String[] XLabel;    //X的刻度
    public String[] YLabel;    //Y的刻度
    public String[] highTem;      //数据1
    public String[] lowTem;      //数据2
    public ChartView(Context context, AttributeSet attrs) {
    	super(context, attrs);
    	// TODO Auto-generated constructor stub
    	}

    	public ChartView(Context context) {
    	super(context);
    	// TODO Auto-generated constructor stub
    	}
    public void SetInfo(String[] XLabels,String[] YLabels,String[] higntem,String[] lowtem)
    {
        XLabel=XLabels;
        YLabel=YLabels;
        highTem= higntem;
        lowTem = lowtem;
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);//重写onDraw方法

        //canvas.drawColor(Color.WHITE);//设置背景颜色
        Paint paint= new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);//去锯齿
        paint.setColor(Color.rgb(105,105,105));//颜色
        paint.setStrokeWidth((float) 1.5); 
        Paint paint1=new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true);//去锯齿
        paint1.setColor(Color.rgb(50,205,50));
        paint1.setStrokeWidth((float) 6.0); 
        Paint paint2= new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);//去锯齿
        paint2.setColor(Color.rgb(30,144,255));
        paint2.setStrokeWidth((float) 6.0); 
        paint.setTextSize(30);  //设置轴文字大小
       
        //设置Y轴
        // canvas.drawLine(XPoint, YPoint-YLength, XPoint, YPoint, paint);   //轴线
        for(int i=0;i*YScale<YLength ;i++)               
        {
           // canvas.drawLine(XPoint,YPoint-i*YScale, XPoint+5, YPoint-i*YScale, paint);  //刻度
            try
            {
               // canvas.drawText(YLabel[i], XPoint-40, YPoint-i*YScale+5, paint);  //文字
            }
            catch(Exception e)
            {
            }
        }
       // canvas.drawLine(XPoint,YPoint-YLength,XPoint-3,YPoint-YLength+6,paint);  //箭头
       // canvas.drawLine(XPoint,YPoint-YLength,XPoint+3,YPoint-YLength+6,paint);           
       //设置X轴
       // canvas.drawLine(XPoint,YPoint,XPoint+XLength,YPoint,paint);   //轴线
        for(int i=0;i*XScale<XLength;i++)   
        {
            // canvas.drawLine(XPoint+i*XScale, YPoint, XPoint+i*XScale, YPoint-5, paint);  //刻度
            try
            {
                canvas.drawText(XLabel[i] , XPoint+i*XScale-14, YPoint+30, paint);  //文字
                //数据值
                    
                canvas.drawLine(XPoint+(i-1)*XScale, YCoord(highTem[i-1]), XPoint+i*XScale, YCoord(highTem[i]), paint1);
                //canvas.drawCircle(XPoint+i*XScale,YCoord(highTem[i]), 2, paint1);
                   
                canvas.drawLine(XPoint+(i-1)*XScale, YCoord(lowTem[i-1]), XPoint+i*XScale, YCoord(lowTem[i]), paint2);
                //canvas.drawCircle(XPoint+i*XScale,YCoord(lowTem[i]), 2, paint2);
                    
            }
            catch(Exception e)
            {
            }
        }
        
        ////有待解决
       /** for(int i = 0;i <6;i++){
        	canvas.drawText(highTem[i], XPoint+(i)*XScale, YCoord(highTem[i])+15, paint1);
        	canvas.drawText(lowTem[i], XPoint+(i)*XScale, YCoord(lowTem[i])-15, paint2);
        }
       */
      //  canvas.drawLine(XPoint+XLength,YPoint,XPoint+XLength-6,YPoint-3,paint);    //箭头
      //  canvas.drawLine(XPoint+XLength,YPoint,XPoint+XLength-6,YPoint+3,paint); 
        canvas.drawText("周",XPoint+XLength-2,YPoint-5,paint);
        canvas.drawText("体重(Kg)",XPoint+5,YPoint-YLength+5,paint);
        //canvas.drawText("6天气温", 150*2, 50*2, paint);
    }
    private int YCoord(String y0)  //计算绘制时的Y坐标，无数据时返回-999
    {
        int y;
        try
        {
            y=Integer.parseInt(y0);
        }
        catch(Exception e)
        {
            return -999;    //出错则返回-999
        }
        try
        {
            return YPoint-(y-60)*YScale/5;
        }
        catch(Exception e)
        {
        }
        return y;
    }
}
