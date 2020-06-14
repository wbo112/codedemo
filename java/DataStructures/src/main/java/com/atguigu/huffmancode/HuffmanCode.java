package com.atguigu.huffmancode;


import java.util.*;

public class HuffmanCode {
    private static StringBuffer stringBuffer = new StringBuffer();
    private static Map<Byte, String> huffmanCodes = new HashMap<>();

    public static void main(String[] args) {
        String content = "iafweaewewewewi am chinese  ";
        byte[] contentBytes = content.getBytes();
        byte[] huffmanZipBytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(huffmanZipBytes));
        byte[] bytes = decode(huffmanCodes, huffmanZipBytes);
        System.out.println("原来的字符串:" + new String(bytes));
    }

    private static byte[] huffmanZip(byte[] contentBytes) {

        //System.out.println(contentBytes.length);
        List<Node> nodes = getNodes(contentBytes);
        //System.out.println("赫夫曼树");
        Node huffmanTree = createHuffmanTree(nodes);
        // huffmanTree.preOrder();
        getCodes(huffmanTree);
        //System.out.println(huffmanCodes);
        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        // System.out.println("赫夫曼编码  = "+ Arrays.toString(huffmanCodeBytes));
        return huffmanCodeBytes;
    }


    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean flag;
        for (int i = 0; i < huffmanBytes.length; i++) {

            flag = i == huffmanBytes.length - 1;
            stringBuffer.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        System.out.println("huffman解码后:" + stringBuffer.toString());
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        int index = 0;
        String str;

        for (int i = 1; i < stringBuffer.length() + 1; i++) {
            str = stringBuffer.substring(index, i);
            if (map.containsKey(str)) {
                list.add(map.get(str));
                index = i;
            }

        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    private static Map<Byte, String> getCodes(Node root) {
        if (Objects.nonNull(root)) {

            getCodes(root.left, "0", new StringBuffer());
            getCodes(root.right, "1", new StringBuffer());
        }
        return huffmanCodes;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bytes) {
            stringBuffer.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuffer.toString());
        int len = (stringBuffer.length() + 6) / 7;
        byte[] huffmanCodeBytes = new byte[len];
        String strByte;
        int index = 0;
        for (int i = 0; i < stringBuffer.length(); i += 7) {
            if (i + 7 > stringBuffer.length()) {
                strByte = "1" + stringBuffer.substring(i);
            } else {
                strByte = "1" + stringBuffer.substring(i, i+7);

            }

            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }

        return huffmanCodeBytes;
    }

    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;

        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 7);
        } else {
            if (str.length() > 7) {
                return str.substring(str.length() - 7);
            }
            return str.substring(1);
        }

    }


    private static void getCodes(Node node, String code, StringBuffer stringBuffer) {
        StringBuffer stringBuffer1 = new StringBuffer(stringBuffer);
        stringBuffer1.append(code);
        if (Objects.nonNull(node)) {
            if (Objects.isNull(node.data)) {

                getCodes(node.left, "0", stringBuffer1);

                getCodes(node.right, "1", stringBuffer1);

            } else {
                huffmanCodes.put(node.data, stringBuffer1.toString());
            }
        }
    }

    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry :
                map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public static Node createHuffmanTree(List<Node> nodes) {

        if(nodes.size()==1){
            Node leftNode=nodes.get(0);
            Node parent = new Node(null, leftNode.weight );
            parent.left=leftNode;
            nodes.remove(leftNode);
            nodes.add(parent);
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (Objects.nonNull(left)) {
            left.preOrder();
        }
        if (Objects.nonNull(right)) {
            right.preOrder();
        }
    }
}
