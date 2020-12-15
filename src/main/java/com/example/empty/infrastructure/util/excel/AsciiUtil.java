package com.example.empty.infrastructure.util.excel;

public class AsciiUtil {

    public static final char SBC_SPACE = 12288; // 全角空格 12288

    public static final char DBC_SPACE = 32; //半角空格 32

    // ASCII character 33-126 <-> unicode 65281-65374
    public static final char ASCII_START = 33;

    public static final char ASCII_END = 126;

    public static final char UNICODE_START = 65281;

    public static final char UNICODE_END = 65374;

    public static final char DBC_SBC_STEP = 65248; // 全角半角转换间隔

    public static char sbc2dbc(char src){
        if (src == SBC_SPACE) {
            return DBC_SPACE;
        }

        if (src >= UNICODE_START && src <= UNICODE_END) {
            return (char) (src - DBC_SBC_STEP);
        }

        return src;
    }

    /**
     * Convert from SBC case to DBC case
     *
     * @param src
     * @return DBC case
     */
    public static String sbc2dbcCase(String src) {
        if (src == null) {
            return null;
        }
        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = sbc2dbc(c[i]);
        }
        return new String(c);
    }

    public static char dbc2sbc(char src){
        if (src == DBC_SPACE) {
            return SBC_SPACE;
        }
        if (src <= ASCII_END) {
            return (char) (src + DBC_SBC_STEP);
        }
        return src;
    }

    /**
     * Convert from DBC case to SBC case.
     *
     * @param src
     * @return SBC case string
     */
    public static String dbc2sbcCase(String src) {
        if (src == null) {
            return null;
        }

        char[] c = src.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = dbc2sbc(c[i]);
        }

        return new String(c);
    }
    
    public static void main(String[] args) {
    	System.out.println(AsciiUtil.sbc2dbcCase("ｈｅｌｌｏ ｗｏｒｌｄ"));
        System.out.println(AsciiUtil.dbc2sbcCase("hello world"));
        
        System.out.println(AsciiUtil.sbc2dbcCase("一区１号"));
        System.out.println(AsciiUtil.dbc2sbcCase("一区1号"));
        
        System.out.println(AsciiUtil.sbc2dbcCase("０８２１２５１Ｘ"));
        System.out.println(AsciiUtil.sbc2dbcCase("0821251X"));
	}
}