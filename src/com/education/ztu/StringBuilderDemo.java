package com.education.ztu;

public class StringBuilderDemo {
    public static void main(String[] args) {
        int a = 4, b = 36;
        StringBuilder sb = new StringBuilder();

        sb.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n")
                .append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n")
                .append(a).append(" * ").append(b).append(" = ").append(a * b);

        System.out.println(sb);

        // Заміна "=" на "рівно"
        StringBuilder sb2 = new StringBuilder("4 + 36 = 40");
        int eqIndex = sb2.indexOf("=");
        sb2.replace(eqIndex, eqIndex + 1, " рівно ");
        System.out.println(sb2);

        // Reverse
        sb.reverse();
        System.out.println("Реверс:\n" + sb);

        // Length and Capacity
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}

