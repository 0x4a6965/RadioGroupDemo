package com.example.administrator.radiogroupdemo;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Checkable;

public class GridRadioButton extends AppCompatRadioButton implements Checkable {

	private boolean mChecked;
	private OnCheckedChangeListener mOnCheckedChangeListener;
	private OnCheckedChangeListener mOnCheckedChangeWidgetListener;

	public GridRadioButton(Context context) {
		this(context, null);
	}

	public GridRadioButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GridRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
		this(context, attrs, defStyleAttr, 0);
	}

	public GridRadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				performClick();
				break;
		}
		return super.onTouchEvent(event);
	}

	/**
	 * Register a callback to be invoked when the checked state of this button
	 * changes.
	 *
	 * @param listener the callback to call on checked state change
	 */
	public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
		mOnCheckedChangeListener = listener;
	}

	/**
	 * Register a callback to be invoked when the checked state of this button
	 * changes. This callback is used for internal purpose only.
	 *
	 * @param listener the callback to call on checked state change
	 * @hide
	 */
	void setOnCheckedChangeWidgetListener(OnCheckedChangeListener listener) {
		mOnCheckedChangeWidgetListener = listener;
	}

	@Override
	public void setChecked(boolean checked) {
		if (mChecked != checked) {
			mChecked = checked;
			setSelected(checked);
			refreshDrawableState();
			if (mOnCheckedChangeListener != null) {
				mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
			}
			if (mOnCheckedChangeWidgetListener != null) {
				mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		setSelected(mChecked);
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
	}

	/**
	 * Interface definition for a callback to be invoked when the checked state
	 * of a compound button changed.
	 */
	public interface OnCheckedChangeListener {
		/**
		 * Called when the checked state of a compound button has changed.
		 *
		 * @param buttonView The compound button view whose state has changed.
		 * @param isChecked  The new checked state of buttonView.
		 */
		void onCheckedChanged(View buttonView, boolean isChecked);
	}

	@Override
	public boolean isChecked() {
		return mChecked;
	}

	@Override
	public boolean performClick() {
		toggle();

		final boolean handled = super.performClick();
		if (!handled) {
			// View only makes a sound effect if the onClickListener was
			// called, so we'll need to make one here instead.
			playSoundEffect(SoundEffectConstants.CLICK);
		}

		return handled;
	}

	@Override
	public void toggle() {
		if (!isChecked()) {
			setChecked(!mChecked);
		}
	}

}
