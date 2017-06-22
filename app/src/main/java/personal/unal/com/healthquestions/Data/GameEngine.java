package personal.unal.com.healthquestions.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JuanCamilo on 11/06/2017.
 */

public class GameEngine implements Parcelable {
    public static final Creator<GameEngine> CREATOR = new Creator<GameEngine>() {
        @Override
        public GameEngine createFromParcel(Parcel in) {
            return new GameEngine(in);
        }

        @Override
        public GameEngine[] newArray(int size) {
            return new GameEngine[size];
        }
    };
    private String playerName;
    private int score;
    private int progress;
    private int total;
    private ArrayList<PowerUp> powers;
    private List<Question> questionList;

    public GameEngine(String playerName, int score, int progress) {
        this.playerName = playerName;
        this.score = score;
        this.progress = progress;
        this.total = 10;
        this.questionList = new ArrayList<>(15);
    }

    protected GameEngine(Parcel in) {
        playerName = in.readString();
        score = in.readInt();
        progress = in.readInt();
        total = in.readInt();
        powers = in.createTypedArrayList(PowerUp.CREATOR);
        questionList = in.createTypedArrayList(Question.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playerName);
        dest.writeInt(score);
        dest.writeInt(progress);
        dest.writeInt(total);
        dest.writeTypedList(powers);
        dest.writeTypedList(questionList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void initGame() {
        powers = new ArrayList<>(3);
        powers.add(new RemoveOptions());
        powers.add(new PublicHelp());
        powers.add(new RemoveOptions());

        Question q = new Question("El erotismo es la capacidad humana de experimentar las respuestas subjetivas que evocan los fenómenos físicos percibidos como deseo sexual. Tales como. excepto");
        q.addAnswerOption(new AnswerOption("Excitación sexual ", false));
        q.addAnswerOption(new AnswerOption("Orgasmo", false));
        q.addAnswerOption(new AnswerOption("Sensualidad ", true));
        q.addAnswerOption(new AnswerOption("Placer sexual", false));

        questionList.add(q);

        q = new Question("Existen dos confusiones bastante generalizadas con respecto al concepto de género. La primera, es que género es igual a sexo; la segunda, que género equivale a mujer, cuál sería el concepto real de género: ");
        q.addAnswerOption(new AnswerOption("La condición biológica de los sujetos que tienen unas características comunes.", false));
        q.addAnswerOption(new AnswerOption("La división de la humanidad en dos sexos.", false));
        q.addAnswerOption(new AnswerOption("Se nace con género.", false));
        q.addAnswerOption(new AnswerOption("Es un rol socialmente construido. ", true));

        questionList.add(q);

        q = new Question("La igualdad de género es una cuestión relevante para:");
        q.addAnswerOption(new AnswerOption("Mujeres y niñas", false));
        q.addAnswerOption(new AnswerOption("Los países en desarrollo", false));
        q.addAnswerOption(new AnswerOption("Todas las sociedades por igual", true));
        q.addAnswerOption(new AnswerOption("Movimientos feministas en todo el mundo", false));

        questionList.add(q);

        q = new Question("El término “sexo”. se refiere a:");
        q.addAnswerOption(new AnswerOption("Conjunto de características biológicas que define hembras y machos", true));
        q.addAnswerOption(new AnswerOption("Es la practica sexual entre individuos.", false));
        q.addAnswerOption(new AnswerOption("Conjunto de personas o cosas que tienen características generales comunes.", false));
        q.addAnswerOption(new AnswerOption("Distinción social y cultural entre individuos", false));

        questionList.add(q);

        //5
        q = new Question("La orientación sexual es la organización específica del erotismo y/o el vínculo emocional de un individuo en relación al género de la pareja involucrada en la actividad sexual. La orientación sexual puede manifestarse en forma de:");
        q.addAnswerOption(new AnswerOption("Comportamientos, pensamientos", false));
        q.addAnswerOption(new AnswerOption("Deseos sexuales, y fantasías", false));
        q.addAnswerOption(new AnswerOption("En una combinación de estos elementos", false));
        q.addAnswerOption(new AnswerOption("Todas las anteriores ", true));

        questionList.add(q);

        q = new Question("Se considera problemas de salud sexual o síndromes clínicos (Parafilias) relacionados con identidad de género a:");
        q.addAnswerOption(new AnswerOption("Búsqueda compulsiva de relaciones y de parejas múltiples", false));
        q.addAnswerOption(new AnswerOption("Fijación compulsiva en una pareja inalcanzable Autoerotismo compulsivo", true));
        q.addAnswerOption(new AnswerOption("Síndromes intersexuales", false));
        q.addAnswerOption(new AnswerOption("Comportamiento sexual compulsivo en una relación", false));

        questionList.add(q);

        q = new Question("La identidad sexual nos define como");
        q.addAnswerOption(new AnswerOption("Hombre y mujer", false));
        q.addAnswerOption(new AnswerOption("Vivencias sexuales", false));
        q.addAnswerOption(new AnswerOption("Percepción intima sobre si mismos", false));
        q.addAnswerOption(new AnswerOption("Características que definen a un grupo de personas", true));

        questionList.add(q);

        q = new Question("El sexo se define como las diferencias entre hombres y mujeres dadas por su condición, excepto:");
        q.addAnswerOption(new AnswerOption("Biológica y fisiológica", false));
        q.addAnswerOption(new AnswerOption("Cromosómica y hormonales", false));
        q.addAnswerOption(new AnswerOption("Genitales y reproductivas", false));
        q.addAnswerOption(new AnswerOption("Biológicas y neurológicas", true));

        questionList.add(q);

        q = new Question("Muchas mujeres que constituyen la población carcelaria son cabeza de familia, esta variable de género tiene un impacto de trascendencia, porque");
        q.addAnswerOption(new AnswerOption("La economía del país se basa fundamentalmente en la actividad de la mujer ", false));
        q.addAnswerOption(new AnswerOption("Se incrementa el número de hombres cabeza de familia", false));
        q.addAnswerOption(new AnswerOption("En nuestro entorno social la mujer es fundamental para el funcionamiento del núcleo familiar", true));
        q.addAnswerOption(new AnswerOption("La degradación de la mujer es mayor que la del hombre al interior del penal", false));

        questionList.add(q);

        q = new Question("La violencia intrafamiliar como fenómeno social, puede ser disminuida si");
        q.addAnswerOption(new AnswerOption("Las comisarías de familia se apropian de su responsabilidad frente a la situación", false));
        q.addAnswerOption(new AnswerOption("Se favorece la cohesión y se cultivan valores al interior de las familias ", true));
        q.addAnswerOption(new AnswerOption("El Estado crea entidades que fomenten la sana convivencia", false));
        q.addAnswerOption(new AnswerOption("La participación de la sociedad civil genera la construcción de la cultura ciudadana", false));

        questionList.add(q);

        q = new Question("Desde 1901 los premios NOBEL se han entregado a 768 personas y 19 organizaciones ¿Cuántas mujeres han recibido este premio?");
        q.addAnswerOption(new AnswerOption("12", false));
        q.addAnswerOption(new AnswerOption("33", true));
        q.addAnswerOption(new AnswerOption("8", false));
        q.addAnswerOption(new AnswerOption("42", false));

        questionList.add(q);

        q = new Question("Si el sexo se refiere a las diferencias biológicas entre hombres y mujeres, el género se refiere a:");
        q.addAnswerOption(new AnswerOption("Funciones construidas socialmente ", false));
        q.addAnswerOption(new AnswerOption("Un concepto que puede cambiar con el tiempo", false));
        q.addAnswerOption(new AnswerOption("Feminidad y masculinidad", false));
        q.addAnswerOption(new AnswerOption("Todas las anteriores", true));

        questionList.add(q);

        q = new Question("Sufragismo colombiano significó un movimiento social de Resistencia a causa de la exclusión femenina, y se da a partir de los años:");
        q.addAnswerOption(new AnswerOption("1930", true));
        q.addAnswerOption(new AnswerOption("1943", false));
        q.addAnswerOption(new AnswerOption("1950", false));
        q.addAnswerOption(new AnswerOption("1954", false));

        questionList.add(q);


        Collections.shuffle(questionList);
    }


    public List<Question> getQuestionList() {
        return this.questionList;
    }

    public ArrayList<PowerUp> getPowers() {
        return this.powers;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }


    public int getUsedPowers() {
        int used = 0;
        for (PowerUp pw : getPowers()) {
            if (pw.isUsed()) {
                used++;
            }
        }
        return used;
    }
}
