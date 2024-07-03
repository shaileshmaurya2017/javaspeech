import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        //System.setProperty("mbrola.base", "de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
      //  System.setProperty("freetts.voices", "de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16"); //16" //alan
//         Voice voice = voiceManager.getVoice("alan");

      //  Voice voice = voiceManager.getVoice("mbrola_us1");

     //   voice.setRate(100f);
        System.out.println(voice.getRate());
        System.out.println(voiceManager.getVoiceInfo());

        if (voice == null) {
            System.err.println("Cannot find voice: kevin16");
            System.exit(1);
        }
        voice.allocate();
        String message = """
                A full          
                """;
        voice.speak("Hello, world!");
        voice.speak(message);

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        String str = "";
        ArrayList<String> questions = new ArrayList<String>();
        questions.add("Hi, whats your name ?");
        questions.add("your age ?");

        HashMap<String,String> answers = new HashMap<String,String>();
        int i=0;
        while(!str.equals("e") || questions.size() == i){
            System.out.print(questions.get(i));
            System.out.print(" or press e to exit");
            voice.speak(questions.get(i));
            str= sc.nextLine();
            answers.put(questions.get(i),str);
            voice.speak(answers.get(questions.get(i)));
            i++;
            if(questions.size() == i)
                break;

        }


        voice.deallocate();
    }
}