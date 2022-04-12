package A2_BitManipulation;

public class BitManipulation {
    static boolean getBit(int num, int i){
        // Get the i_th bit (indexed-0 from the right);
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i){
        // Turn the i_th bit into 1 (indexed-0 from the right); 
        // E.g. setBit(10, 1): 1000 | 0001 -> 1001
        return num | (1 << i);
    }

    static int clearBit(int num, int i){
        // Turn the i_th bit into 0;
        // E.g. clearBit(15, 2): 1111 & 1011 -> 1011
        return num & ~(1 << i);
    }

    static int clearBitsMSBThroughI(int num, int i){
        // clear from MSB to i_bit(inclusive)
        // E.g. clearBitsMSBThroughI(15, 3): 1111 & 0111 = 0111
        int mask = (1 << i) - 1; // 1111 - 1 = 0111;
        return num & mask; 
    }

    static int clearBitsIThrough0(int num, int i){
        // clear from i_th to MSB (inclusive)
        // E.g clearBitsIThrough0(15, 2): 1111 & 1000 = 1000
        int mask = (-1 << (i + 1));// 1111 shift left by 3
        return num & mask;
    }
    public static void main(String[] args) {
        System.out.println(getBit(9, 1));
        System.out.println(setBit(8, 0));
        System.out.println(clearBit(15, 2));
        System.out.println(clearBitsMSBThroughI(15, 3));
        System.out.println(clearBitsIThrough0(15, 2)); 
    }
}
