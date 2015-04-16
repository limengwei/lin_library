package com.linwoain.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linwoain.library.R;

public class ImageWithText extends LinearLayout {
	protected TextView tv;
	protected ImageView iv;
	private int mDefaultIconId;
	private int mPressedIconId;
	private static int mDefaultBackgroudId;
	private static int mPressedBackgroudId;
	private static List<ImageWithText> list = new ArrayList<ImageWithText>();

	public ImageWithText(Context context) {
		super(context);
		init(null, 0);
	}

	public ImageWithText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs, 0);
	}

	public void init(AttributeSet attrs, int style) {
		if (isInEditMode()) {
			return;
		}
		View.inflate(getContext(), R.layout.sample_image_with_text, this);

		tv = (TextView) findViewById(R.id.tv);
		iv = (ImageView) findViewById(R.id.iv);
		if (attrs != null) {
			TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ImageWithText);
			this.setText(a.getText(R.styleable.ImageWithText_text).toString());
			this.setDefaultIconId(a.getResourceId(R.styleable.ImageWithText_src, R.drawable.ic_launcher));
			a.recycle();
			this.setImageViewRes(getDefaultIconId());
		}
		list.add(this);
	}

	/**
	 * 设置当前控件位选中，并重置其他
	 */
	public void setSelect() {
		for (ImageWithText lwt : list) {
			lwt.setUnPressed();
			
		}
		setBackgroundResource(getPressedBackgroudId());
		setImageViewRes(getPressedIconId());
	}

	private void setUnPressed() {
		setBackgroundResource(getDefaultBackgroudId());
		setImageViewRes(mDefaultIconId);
	}

	/**
	 * 设置文字
	 * 
	 * @param text 要设置的文字
	 */
	public void setText(String text) {
		tv.setText(text);
	}

	/**
	 * 设置imageview的图片
	 * 
	 * @param resId 资源id
	 */
	public void setImageViewRes(int resId) {
		iv.setImageResource(resId);
	}

	/**
	 * 设置imageview的图片
	 * 
	 * @param bitmap 位图
	 */
	public void setImageBitmap(Bitmap bitmap) {
		iv.setImageBitmap(bitmap);

	}

	/**
	 * @return the mDefaultIconId
	 */
	public int getDefaultIconId() {
		return mDefaultIconId;
	}

	/**
	 * @param mDefaultIconId the mDefaultIconId to set
	 */
	public void setDefaultIconId(int mDefaultIconId) {
		this.mDefaultIconId = mDefaultIconId;
	}

	/**
	 * @return the mPressedIconId
	 */
	public int getPressedIconId() {
		return mPressedIconId;
	}

	/**
	 * @param mPressedIconId the mPressedIconId to set
	 */
	public void setPressedIconId(int mPressedIconId) {
		this.mPressedIconId = mPressedIconId;
	}

	/**
	 * @return the mPressedBackgroudId
	 */
	public int getPressedBackgroudId() {
		return mPressedBackgroudId;
	}

	/**
	 * 设置按下去时的背景 所有同类控件共享此设置
	 * @param mPressedBackgroudId the mPressedBackgroudId to set
	 */
	public void setPressedBackgroudId(int mPressedBackgroudId) {
		ImageWithText.mPressedBackgroudId = mPressedBackgroudId;
	}

	/**
	 * @return the mDefaultBackgroudId
	 */
	public static int getDefaultBackgroudId() {
		return mDefaultBackgroudId;
	}

	/**
	 * 设置默认的控件背景，所有此类控件共享此设置
	 * @param mDefaultBackgroudId the mDefaultBackgroudId to set
	 */
	public static void setDefaultBackgroudId(int mDefaultBackgroudId) {
		ImageWithText.mDefaultBackgroudId = mDefaultBackgroudId;
	}

}
