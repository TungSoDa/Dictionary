package tudien;

public class DeleteAndFix 
{
    public static void replaceSelected(String replace, String replaceWith)
        {
                try
                {
                        BufferedReader file = new BufferedReader(new FileReader("data/replacer.txt"));
                        String line;
                        String input = "";
                        while ((line = file.readLine()) != null) input += line + '\n';
                        input = input.replace(replace, replaceWith);
                        FileOutputStream File = new FileOutputStream("data/replacer.txt");
                        File.write(input.getBytes());
                }
                catch (Exception e)
                {
                        System.out.println("Problem reading file.");
                }
        }
    
    public static void deleteLine()
    {
        try
        {
                BufferedReader file = new BufferedReader(new FileReader("data/line.txt"));
                String line;
                String input = "";
                while ((line = file.readLine()) != null) 
                {
                    //System.out.println(line);
                    if (line.contains("Username:"))
                    {
                        line = "";
                        System.out.println("Line deleted.");
                    }
                    input += line + '\n';
                }
                FileOutputStream File = new FileOutputStream("data/line.txt");
                File.write(input.getBytes());
                file.close();
                File.close();
        }
        catch (Exception e)
        {
                System.out.println("Problem reading file.");
        }
    }
}
