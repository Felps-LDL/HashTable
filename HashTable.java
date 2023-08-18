import java.util.ArrayList;
import java.util.Scanner;

public class HashTable
{
    public int M = 19;

    public ArrayList<ArrayList<String>> ht;

    public HashTable()
    {
        this.ht = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < M; i++)
        {
            this.ht.add(new ArrayList<String>());
        }
    }

    public void put(int chave, String nome)
    {
        this.ht.get(chave).add(nome);
    }

    public int qtd(int chave)
    {
        return this.ht.get(chave).size();
    }

    public int hashCode(String nome)
    {
        // Devolve o índice baseado na primeira letra (questão 1)
        //return (int)(nome.charAt(0) - 'A');

        // (questão 2 e 3)
        int h = 0;
        for (int i=0; i <nome.length(); i++)
            h = (37 * h + nome.charAt(i)) % M;

        return h;
    }

    public int size()
    {
        return M;
    }

    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        HashTable hashtable = new HashTable();
        int M = hashtable.size();

        for (int i = 0; i < 270; i++)
        {
            String nome = scan.nextLine();
            int pos = hashtable.hashCode(nome);

            hashtable.put(pos, nome);
        }
 
        int letra = 0;

        for (int i = 0; i < M; i++)
        {
            int cont = hashtable.qtd(i);

            System.out.println("hashtable[" + i + "] "+ (char)('A' + letra) + " - " + cont);
            letra++;
        }

        scan.close();
    }
}