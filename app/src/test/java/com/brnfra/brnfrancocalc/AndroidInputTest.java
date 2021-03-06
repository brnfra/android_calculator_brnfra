package com.brnfra.brnfrancocalc;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machnumbere (host).
 *
 * @see <a href="http://d.android.com/tools/testnumberg">Testnumberg documentation</a>
 */

public class AndroidInputTest {
    private Inputs number;
    private Outputs res;
    private Operations make;
    private Digit dig;
    private Operating op;
    private Outputing out;

    @Before
    public void startObj() {
        this.number = new Inputs();
        this.res = new Outputs();
        this.make = new Operations();

        this.dig=number;
        this.out=res;
        this.op=make;
    }

    @Test
    public void btnDigitTest() {

                          //zero-nnumbere-zero
    dig.passDigit('0');
    dig.passDigit('1');
    dig.passDigit('2');
    dig.passDigit('3');
    dig.passDigit('4');
    dig.passDigit('5');
    dig.passDigit('6');
    dig.passDigit('7');
    dig.passDigit('8');
    dig.passDigit('9');
    dig.passDigit('0');
    assertEquals("1234567890",number.getNumber() );

    }

    @Test
    public void btnDigitDotTest() {
        //reset
        dig.reset(number);
        //dot test
        dig.passDigit('5');
        dig.passDigit('.');
        dig.passDigit('1');
        dig.passDigit('0');
        dig.passDigit('5');
        assertEquals("5.105",number.getNumber());
    }

    @Test
    public void btnDigitDoubleDotTest() {
        //double dot
        number.setNumber("72");
        dig.passDigit('.');
        dig.passDigit('.');
        assertEquals("72.",number.getNumber());
    }

    @Test
    public void btnDigitDoubleZeroTest() {
        number.setNumber("0");
        //dot test
        dig.passDigit('0');
        dig.passDigit('0');
        dig.passDigit('.');
        dig.passDigit('0');
        assertEquals("0.0",number.getNumber());
    }


    @Test
    public void addTest(){
        dig.passDigit('1');
        dig.passDigit('0');
        dig.passDigit('.');
        dig.passDigit('3');
        op.add(number);
        dig.passDigit('0');
        dig.passDigit('1');
        dig.passDigit('3');
        op.add(number);
        assertEquals("23.3",out.formatOut(make.getResult()));

    }
    @Test
    public void outputAddStringTest(){
        String saida = "";
        dig.reset(number);
        dig.setNumber("110");
        make.add(number);
        saida = out.formatOut(make.getResult()) ;
        saida=saida + "+";
        assertEquals("110+",saida);
    }
    @Test
    public void outputMultiStringAfterEqualsTest(){
        String saida = "";
        dig.reset(number);
        dig.setNumber("110");
        make.add(number);
        dig.setNumber("10");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        make.multi(number);
        saida = out.formatOut(make.getResult()) ;
        saida=saida.concat("x") ;
        assertEquals("120x",saida);
    }
    @Test
    public void addAfterEqualsTest(){

        dig.reset(number);
        dig.setNumber("10");
        op.add(number);
        dig.setNumber("32");
        make.setEquals(number);
        assertEquals("42",out.formatOut(make.getResult()));
    }
    @Test
    public void subtTest(){
        dig.setNumber("103");
        op.subt(number);
        dig.passDigit('0');
        dig.passDigit('0');
        dig.passDigit('3');
        op.subt(number);
        dig.setNumber("103");
        op.subt(number);
        make.setEquals(number);
        assertEquals(-3.0,op.getResult(),0.00001);
    }
    @Test
    public void outputSubtStringTest(){
        String saida = "";

        dig.setNumber("196");
        make.subt(number);
        saida = out.formatOut(make.getResult()) ;
        saida=saida + "-";

        assertEquals("196-",saida);
    }
    @Test
    public void subtAfterEqualsTest(){

        dig.reset(number);
        dig.setNumber("50");
        op.subt(number);
        dig.setNumber("32");
        make.setEquals(number);
        assertEquals("18",out.formatOut(make.getResult()));
    }
    @Test
    public void multiTest(){

        dig.passDigit('1');
        dig.passDigit('0');
        dig.passDigit('3');
        op.multi(number);
        dig.passDigit('0');
        dig.passDigit('0');
        dig.passDigit('3');
        op.multi(number);
        assertEquals(309.0,op.getResult(),0.00001);

    }
    @Test
    public void multiAfterEqualsTest(){
        dig.reset(number);
        dig.setNumber("10");
        op.multi(number);
        dig.setNumber("32");
        make.setEquals(number);
        assertEquals("320",out.formatOut(make.getResult()));
    }
    @Test
    public void outputMultiStringTest(){
        String saida = "";

        dig.setNumber("96");

        make.multi(number);
        saida = out.formatOut(make.getResult()) ;
        saida=saida + "x";

        assertEquals("96x",saida);
    }
    @Test
    public void dividTest(){

        dig.passDigit('0');
        dig.passDigit('9');
        dig.passDigit('9');
        op.divid(number);
        dig.passDigit('0');
        dig.passDigit('0');
        dig.passDigit('3');
        op.divid(number);
        assertEquals(33.0, op.getResult(), 0.00001);

    }
    @Test
    public void dividAfterEqualsTest(){
        dig.reset(number);
        dig.setNumber("32");
        op.divid(number);
        dig.setNumber("10");
        make.setEquals(number);
        assertEquals("3.2",out.formatOut(make.getResult()));
    }
    @Test
    public void outputDividStringTest(){
        String saida = "";
        dig.setNumber("6");
        make.divid(number);
        saida = out.formatOut(make.getResult()) ;
        saida=saida + "÷";
        assertEquals("6÷",saida);
    }
    @Test
    public void equalsTest(){

        dig.passDigit('1');
        op.add(number);
        dig.passDigit('3');
        op.add(number);
        dig.passDigit('1');
        op.subt(number);
        dig.passDigit('2');
        op.multi(number);
        dig.passDigit('2');
        op.divid(number);
        assertEquals("3",out.formatOut(make.getResult()));
    }
    @Test
    public void equalsAcumulatorTest(){
        dig.passDigit('1');
        op.add(number);
        dig.passDigit('3');
        op.add(number);
        dig.passDigit('1');
        op.subt(number);
        dig.passDigit('2');
        op.multi(number);
        dig.passDigit('2');
        op.divid(number);
        make.setAcumulador(make.getResult());
        assertEquals(3.0,make.getAcumulador(),0.0001);
    }

    @Test
    public void subtAfterAddResultTest(){
        number.setNumber("9");
        op.add(number);
        number.setNumber("3");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        op.subt(number);
        number.setNumber("4");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        assertEquals("8",out.formatOut(make.getResult()));

    }

    @Test
    public void equalsAfterSubtResultTest(){
        number.setNumber("9");
        op.subt(number);
        number.setNumber("3");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        op.subt(number);
        number.setNumber("6");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        assertEquals("0",out.formatOut(make.getResult()));

    }

    @Test
    public void equalsAfterMultiResultTest(){
        number.setNumber("9");
        op.add(number);
        number.setNumber("3");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        op.multi(number);
        number.setNumber("2");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        assertEquals("24",out.formatOut(make.getResult()));

    }
    @Test
    public void equalsAfterDividResultTest(){
        number.setNumber("9");
        op.divid(number);
        number.setNumber("3");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        number.setNumber(String.valueOf(make.getAcumulador()));
        op.divid(number);
        number.setNumber("2");
        make.setEquals(number);
        make.setAcumulador(make.getResult());
        assertEquals("1.5",out.formatOut(make.getResult()));

    }

    @Test
    public void btnResultsTest() {

        number.setNumber("0.9");
        assertEquals("0.9", out.formatOut(0.9) );
    }
    @Test
    public void btnResultsNullTest() {
        number.setNumber("");
        assertEquals("0", out.formatOut(make.getResult()) );
    }
    @Test
    public void btnResultsFormatingTest() {
        number.setNumber("0.000009");
        assertEquals("9.00e-06", out.formatOut(0.000009) );
    }
    @Test
    public void btnResultsFormatingHeavyDoubleTest() {
        number.setNumber("987654321678");
        assertEquals("9.88e+11", out.formatOut(987654321678.0) );
    }
    @Test
    public void resetNumberTest(){
        dig.passDigit('1');
        dig.passDigit('0');
        dig.passDigit('3');
        dig.reset(number);
        assertEquals("",number.getNumber());
    }
    @Test
    public void allClearTest(){
        make.setParcela("0");
        make.setAcumulador(0.0);
        make.setContinua(0);
        make.setOperacao(0);
        dig.reset(number);
        make.add(number);
        make.subt(number);
        make.multi(number);
        make.divid(number);
        make.setParcela("0");
        make.setAcumulador(0.0);
        make.setContinua(0);
        make.setOperacao(0);
        make.setEquals(number);
        make.setResult(0.0);
        assertEquals("0",out.formatOut(make.getResult()));
    }


}