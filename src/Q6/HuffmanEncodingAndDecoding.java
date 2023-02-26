package Q6;// Q6. Implement Huffman encoding and decoding.


import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanEncodingAndDecoding {

    // Node class for building Huffman tree
    private static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left;
        Node right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message to be encoded: ");
        String message = sc.nextLine();

        int[] freq = new int[256];
        for (char ch : message.toCharArray()) {
            freq[ch]++;
        }

        Node root = buildTree(freq);
        String[] codes = buildCodes(root);

        System.out.println("Huffman codes:");
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] != null) {
                System.out.println((char) i + ": " + codes[i]);
            }
        }

        String encodedMessage = encode(message, codes);
        System.out.println("Encoded message: " + encodedMessage);

        String decodedMessage = decode(encodedMessage, root);
        System.out.println("Decoded message: " + decodedMessage);
    }

    // Add all characters and their frequencies to priority queue
    private static Node buildTree(int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.offer(new Node((char) i, freq[i], null, null));
            }
        }
    // Merge nodes while only one remains
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.offer(new Node('\0', left.freq + right.freq, left, right));
        }
    // Return the root of the Huffman tree
        return pq.poll();
    }

    private static String[] buildCodes(Node root) {
        String[] codes = new String[256];
        buildCodesHelper(root, "", codes);
        return codes;
    }

    private static void buildCodesHelper(Node node, String code, String[] codes) {
        if (node == null) {
            return;
        }

        if (node.ch != '\0') {
            codes[node.ch] = code;
        }

        buildCodesHelper(node.left, code + "0", codes);
        buildCodesHelper(node.right, code + "1", codes);
    }

    // Encode message using Huffman codes
    private static String encode(String message, String[] codes) {
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            sb.append(codes[ch]);
        }
        return sb.toString();
    }
    // Decode message using Huffman codes
    private static String decode(String encodedMessage, Node root) {
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for (char bit : encodedMessage.toCharArray()) {
            if (bit == '0') {
                node = node.left;
            } else {
                node = node.right;
            }

            if (node.ch != '\0') {
                sb.append(node.ch);
                node = root;
            }
        }
        return sb.toString();
    }
}
