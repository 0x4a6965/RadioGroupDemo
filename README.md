# RadioGroupDemo
```
for (int i = 0; i < list.size(); i++) {
  // 设置间距
  GridRadioGroup.LayoutParams gl = new GridLayout.LayoutParams();
  gl.topMargin = (int) getResources().getDimension(R.dimen.dimen5);
  gl.leftMargin = (int) getResources().getDimension(R.dimen.dimen5);
  gl.rightMargin = (int) getResources().getDimension(R.dimen.dimen5);

  GridRadioButton grbCurrency = (GridRadioButton) getLayoutInflater().inflate(R.layout.view_radio_button_item, null);
  grbCurrency.setId(i);
  grbCurrency.setText(list.get(i));
  grbCurrency.setLayoutParams(gl);

  mRbGroup.addView(grbCurrency);
}
```
