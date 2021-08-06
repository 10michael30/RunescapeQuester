package MainScript;

import Quester.*;

import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "ThatGuyCalledRob v1.41", name = "Novice Quester", info = "Does Quests", version = 1.41
        , logo = "")

public final class QuesterEntry extends Script {
    public static boolean VERBOSE = true;

    private final Quest sheepQuest = new SheepQuest();
    private final Quest romeoAndJuliet = new RomeoAndJuliet();
    private final Quest cooksAssistant = new CooksAssistant();
    private final Quest runeMysteries = new RuneMysteries();
    private final Quest restlessGhost = new RestlessGhost();
    @Override
    public final void onStart() throws InterruptedException {
        log("----------------------------------------------------------------------");
        log("-------------------------------Starting-------------------------------");
        log("----------------------------------------------------------------------");
        sheepQuest.exchangeContext(getBot());
        sheepQuest.PassBotReferance();

        romeoAndJuliet.exchangeContext(getBot());
        romeoAndJuliet.PassBotReferance();

        cooksAssistant.exchangeContext(getBot());
        cooksAssistant.PassBotReferance();

        runeMysteries.exchangeContext(getBot());
        runeMysteries.PassBotReferance();

        restlessGhost.exchangeContext(getBot());
        restlessGhost.PassBotReferance();
    }

    @Override
    public final int onLoop() throws InterruptedException {

        switch(WhackAQuest()){
            case 0:
                stop();
                break;
            case 1:
                sheepQuest.onLoop();
                break;
            case 2:
                romeoAndJuliet.onLoop();
                break;
            case 3:
                cooksAssistant.onLoop();
                break;
            case 4:
                runeMysteries.onLoop();
                break;
            case 5:
                restlessGhost.onLoop();
                break;
        }

        return 200;
    }

    private int WhackAQuest() {
        if (!sheepQuest.isComplete()){
            return 1;
        }

        if (!romeoAndJuliet.isComplete()){
            return 2;
        }

        if (!cooksAssistant.isComplete()){
            return 3;
        }

        if (!runeMysteries.isComplete()){
            return 4;
        }

        if (!restlessGhost.isComplete()){
            return 5;
        }

        return 0;
    }
}