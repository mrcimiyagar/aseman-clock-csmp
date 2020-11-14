package home;

import csmp.callbacks.terminal.OnBotViewInitialized;
import csmp.helpers.LogHelper;
import csmp.models.*;
import csmp.rxbus.Subscribe;
import csmp.rxbus.notifications.*;
import io.reactivex.Maybe;
import org.w3c.dom.Text;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        new Program();
    }

    private CSMP csmp;

    private Program() {
        csmp = new CSMP(9, "+ABC");
        csmp.bus().register(this);
        csmp.start();
    }

    private Controls.Control initHomeView(boolean preview) {
        return makeClock(preview, 200, 200);
    }

    @Subscribe
    public void onBotViewResized(BotViewResized botViewResized) {
        csmp.initBotView(false, botViewResized.getComplexId(), botViewResized.getRoomId(), botViewResized.getUserId(),
                makeClock(false, botViewResized.getNewWidth(), botViewResized.getNewHeight()), new OnBotViewInitialized() {
                    @Override
                    public void botViewInitialized() {

                    }
                });
    }

    @Subscribe
    public void onBotLoaded(BotLoaded botLoaded) {
        List<Codes.Code> codes = new ArrayList<>();

        Codes.Value zeroValue = new Codes.Value();
        zeroValue.setValueType(Codes.DataType.SHORT);
        zeroValue.setValue(0);

        Codes.Value nValue = new Codes.Value();
        nValue.setValueType(Codes.DataType.SHORT);
        nValue.setValue(-90);

        Codes.Variable hourVar = new Codes.Variable();
        hourVar.setName("hourVar");
        hourVar.setValue(zeroValue);
        Codes.Definition hourVarDefinition = new Codes.Definition();
        hourVarDefinition.setVariable(hourVar);
        codes.add(hourVarDefinition);

        Codes.Variable minuteVar = new Codes.Variable();
        minuteVar.setName("minuteVar");
        minuteVar.setValue(zeroValue);
        Codes.Definition minuteVarDefinition = new Codes.Definition();
        minuteVarDefinition.setVariable(minuteVar);
        codes.add(minuteVarDefinition);

        Codes.Variable secondVar = new Codes.Variable();
        secondVar.setName("secondVar");
        secondVar.setValue(zeroValue);
        Codes.Definition secondVarDefinition = new Codes.Definition();
        secondVarDefinition.setVariable(secondVar);
        codes.add(secondVarDefinition);

        Codes.Variable hourDegreeVar = new Codes.Variable();
        hourDegreeVar.setName("hourDegreeVar");
        hourDegreeVar.setValue(zeroValue);
        Codes.Definition hourDegreeVarDefinition = new Codes.Definition();
        hourDegreeVarDefinition.setVariable(hourDegreeVar);
        codes.add(hourDegreeVarDefinition);

        Codes.Variable minuteDegreeVar = new Codes.Variable();
        minuteDegreeVar.setName("minuteDegreeVar");
        minuteDegreeVar.setValue(zeroValue);
        Codes.Definition minuteDegreeVarDefinition = new Codes.Definition();
        minuteDegreeVarDefinition.setVariable(minuteDegreeVar);
        codes.add(minuteDegreeVarDefinition);

        Codes.Variable secondDegreeVar = new Codes.Variable();
        secondDegreeVar.setName("secondDegreeVar");
        secondDegreeVar.setValue(zeroValue);
        Codes.Definition secondDegreeVarDefinition = new Codes.Definition();
        secondDegreeVarDefinition.setVariable(secondDegreeVar);
        codes.add(secondDegreeVarDefinition);

        Codes.Task task = new Codes.Task();
        task.setName("timeTask");
        task.setPeriod(1000);
        task.setCodes(new ArrayList<>());

        Codes.Assignment hourAssignment = new Codes.Assignment();
        hourAssignment.setVariable(hourVar);
        Codes.GetTime getHour = new Codes.GetTime();
        getHour.setDetail(Codes.GetTime.TimeDetail.HOUR12);
        hourAssignment.setValue(getHour);
        task.getCodes().add(hourAssignment);
        Codes.PerformAnim performHourAnim = new Codes.PerformAnim();
        Anims.ControlAnimRotation hourAnim = new Anims.ControlAnimRotation();
        hourAnim.setControlId("hourHand");
        hourAnim.setDuration(750);
        Codes.MathExpMultiply mulHour = new Codes.MathExpMultiply();
        mulHour.setValue1(hourVar);
        Codes.Value thirtyValue = new Codes.Value();
        thirtyValue.setValue(30);
        thirtyValue.setValueType(Codes.DataType.SHORT);
        mulHour.setValue2(thirtyValue);
        Codes.MathExpSum sumHour = new Codes.MathExpSum();
        sumHour.setValue1(mulHour);
        sumHour.setValue2(nValue);
        Codes.Assignment hourDegreeAssignment = new Codes.Assignment();
        hourDegreeAssignment.setVariable(hourDegreeVar);
        hourDegreeAssignment.setValue(sumHour);
        task.getCodes().add(hourDegreeAssignment);
        hourAnim.setVariable(hourDegreeVar);
        performHourAnim.setAnim(hourAnim);
        task.getCodes().add(performHourAnim);

        Codes.Assignment minuteAssignment = new Codes.Assignment();
        minuteAssignment.setVariable(minuteVar);
        Codes.GetTime getMinute = new Codes.GetTime();
        getMinute.setDetail(Codes.GetTime.TimeDetail.MINUTE);
        minuteAssignment.setValue(getMinute);
        task.getCodes().add(minuteAssignment);
        Codes.PerformAnim performMinuteAnim = new Codes.PerformAnim();
        Anims.ControlAnimRotation minuteAnim = new Anims.ControlAnimRotation();
        minuteAnim.setControlId("minuteHand");
        minuteAnim.setDuration(750);
        Codes.MathExpMultiply mulMinute = new Codes.MathExpMultiply();
        mulMinute.setValue1(minuteVar);
        Codes.Value sixValue = new Codes.Value();
        sixValue.setValue(6);
        sixValue.setValueType(Codes.DataType.SHORT);
        mulMinute.setValue2(sixValue);
        Codes.MathExpSum sumMinute = new Codes.MathExpSum();
        sumMinute.setValue1(mulMinute);
        sumMinute.setValue2(nValue);
        Codes.Assignment minuteDegreeAssignment = new Codes.Assignment();
        minuteDegreeAssignment.setVariable(minuteDegreeVar);
        minuteDegreeAssignment.setValue(sumMinute);
        task.getCodes().add(minuteDegreeAssignment);
        minuteAnim.setVariable(minuteDegreeVar);
        performMinuteAnim.setAnim(minuteAnim);
        task.getCodes().add(performMinuteAnim);

        Codes.Assignment secondAssignment = new Codes.Assignment();
        secondAssignment.setVariable(secondVar);
        Codes.GetTime getSecond = new Codes.GetTime();
        getSecond.setDetail(Codes.GetTime.TimeDetail.SECOND);
        secondAssignment.setValue(getSecond);
        task.getCodes().add(secondAssignment);
        Codes.PerformAnim performSecondAnim = new Codes.PerformAnim();
        Anims.ControlAnimRotation secondAnim = new Anims.ControlAnimRotation();
        secondAnim.setControlId("secondHand");
        secondAnim.setDuration(750);
        Codes.MathExpMultiply mulSecond = new Codes.MathExpMultiply();
        mulSecond.setValue1(secondVar);
        mulSecond.setValue2(sixValue);
        Codes.MathExpSum sumSecond = new Codes.MathExpSum();
        sumSecond.setValue1(mulSecond);
        sumSecond.setValue2(nValue);
        Codes.Assignment secondDegreeAssignment = new Codes.Assignment();
        secondDegreeAssignment.setVariable(secondDegreeVar);
        secondDegreeAssignment.setValue(sumSecond);
        task.getCodes().add(secondDegreeAssignment);
        secondAnim.setVariable(secondDegreeVar);
        performSecondAnim.setAnim(secondAnim);
        task.getCodes().add(performSecondAnim);

        Codes.DefineTask defineTask = new Codes.DefineTask();
        defineTask.setTask(task);
        codes.add(defineTask);

        Codes.StartTask startTask = new Codes.StartTask();
        startTask.setTaskName(task.getName());
        codes.add(startTask);

        csmp.runCommandsOnBotView(botLoaded.isWindowMode(),
                botLoaded.getComplexId(),
                botLoaded.getRoomId(),
                botLoaded.getUserId(),
                codes);
    }

    private Controls.PanelCtrl makeClock(boolean preview, int width, int height) {
        int mainSize = Math.min(width, height);
        System.out.println(width + " " + height + " " + mainSize);
        Controls.PanelCtrl clockEl = new Controls.PanelCtrl();
        clockEl.setId("Clock");
        clockEl.setWidth(mainSize);
        clockEl.setHeight(mainSize);
        clockEl.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        clockEl.setX(Controls.Control.CENTER);
        clockEl.setCornerRadius(mainSize * 75 / 150);
        clockEl.setBorderColor("#50a882");
        clockEl.setBorderWidth(3);
        clockEl.setControls(new ArrayList<>());
        if (!preview) clockEl.setClickable(true);

        Controls.ImageCtrl clockBack = new Controls.ImageCtrl();
        clockBack.setImageUrl("https://a.imge.to/2019/08/15/8mXH0.png");
        clockBack.setWidth(Controls.Control.MATCH_PARENT);
        clockBack.setHeight(Controls.Control.MATCH_PARENT);
        clockBack.setMarginTop(mainSize * -8 / 150);
        clockBack.setMarginBottom(mainSize * -8 / 150);
        clockBack.setMarginLeft(mainSize * -8 / 150);
        clockBack.setMarginRight(mainSize * -8 / 150);
        clockBack.setScaleType(Controls.ImageCtrl.ImageScaleType.FIT_XY);
        clockEl.getControls().add(clockBack);

        Controls.PanelCtrl hourHand = new Controls.PanelCtrl();
        hourHand.setId("hourHand");
        hourHand.setWidth(mainSize * 60 / 150);
        hourHand.setHeight(mainSize * 4 / 150);
        hourHand.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        hourHand.setX(Controls.Control.CENTER);
        hourHand.setY(clockEl.getHeight() / 2 - hourHand.getHeight() / 2);
        hourHand.setControls(new ArrayList<>());
        hourHand.setRotation(135);
        clockEl.getControls().add(hourHand);

        Controls.PanelCtrl hourHalfHand = new Controls.PanelCtrl();
        hourHalfHand.setWidth(hourHand.getWidth() / 2);
        hourHalfHand.setHeight(Controls.Control.MATCH_PARENT);
        hourHalfHand.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        hourHalfHand.setBackColor("#50a882");
        hourHalfHand.setX(hourHand.getWidth() / 2);
        hourHalfHand.setControls(new ArrayList<>());
        hourHalfHand.setCornerRadius(mainSize * 4 / 150);
        hourHand.getControls().add(hourHalfHand);

        Controls.PanelCtrl minuteHand = new Controls.PanelCtrl();
        minuteHand.setId("minuteHand");
        minuteHand.setWidth(mainSize * 100 / 150);
        minuteHand.setHeight(mainSize * 4 / 150);
        minuteHand.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        minuteHand.setX(Controls.Control.CENTER);
        minuteHand.setY(clockEl.getHeight() / 2 - minuteHand.getHeight() / 2);
        minuteHand.setControls(new ArrayList<>());
        clockEl.getControls().add(minuteHand);

        Controls.PanelCtrl minuteHalfHand = new Controls.PanelCtrl();
        minuteHalfHand.setWidth(minuteHand.getWidth() / 2);
        minuteHalfHand.setHeight(Controls.Control.MATCH_PARENT);
        minuteHalfHand.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        minuteHalfHand.setBackColor("#50a882");
        minuteHalfHand.setX(minuteHand.getWidth() / 2);
        minuteHalfHand.setControls(new ArrayList<>());
        minuteHalfHand.setCornerRadius(mainSize * 4 / 150);
        minuteHand.getControls().add(minuteHalfHand);

        Controls.PanelCtrl secondHand = new Controls.PanelCtrl();
        secondHand.setId("secondHand");
        secondHand.setWidth(mainSize * 120 / 150);
        secondHand.setHeight(mainSize * 4 / 150);
        secondHand.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        secondHand.setX(Controls.Control.CENTER);
        secondHand.setY(clockEl.getHeight() / 2 - secondHand.getHeight() / 2);
        secondHand.setControls(new ArrayList<>());
        secondHand.setRotation(150);
        clockEl.getControls().add(secondHand);

        Controls.PanelCtrl secondHalfHand = new Controls.PanelCtrl();
        secondHalfHand.setWidth(secondHand.getWidth() / 2);
        secondHalfHand.setHeight(Controls.Control.MATCH_PARENT);
        secondHalfHand.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        secondHalfHand.setBackColor("#70b0d7");
        secondHalfHand.setX(secondHand.getWidth() / 2);
        secondHalfHand.setControls(new ArrayList<>());
        secondHalfHand.setCornerRadius(mainSize * 4 / 150);
        secondHand.getControls().add(secondHalfHand);

        return clockEl;
    }

    @Subscribe
    public void onCsmpStarted(CsmpStarted csmpStarted) {
        csmp.initBotViewToAll(false, initHomeView(false));
        csmp.initBotViewToAll(true, makeWindow(1980, 1280));
    }

    @Subscribe
    public void onMessageReceived(MessageReceived messageReceived) {
        Entities.Message message = messageReceived.getMessage();
        if (message instanceof Entities.TextMessage) {
            String text = ((Entities.TextMessage) message).getText();
            if (text.contains("@clock")) {
                if (text.endsWith("how are u ?")) {
                    csmp.createTextMessage(message.getRoom().getComplex().getComplexId(), message.getRoom().getRoomId(), "fine thanks. how can i help ?", textMessage -> {
                    });
                }
            }
        }
    }

    @Subscribe
    public void onBotAddedToRoom(BotAddedToRoom botAddedToRoom) {

    }

    @Subscribe
    public void onUserClickedBotView(UserClickedBotView userClickedBotView) {

    }

    @Subscribe
    public void onUserRequestedBotView(UserRequestedBotView userRequestedBotView) {
        if (userRequestedBotView.isPreview())
            csmp.initBotView(userRequestedBotView.isWindowMode(),
                    userRequestedBotView.getComplexId(),
                    userRequestedBotView.getRoomId(),
                    userRequestedBotView.getUser().getBaseUserId(),
                    makeClock(true, userRequestedBotView.getWidth(), userRequestedBotView.getHeight()),
                    () -> {});
        else
            pushInitialHomeViewToClient(userRequestedBotView.isWindowMode(), userRequestedBotView.getComplexId(),
                    userRequestedBotView.getRoomId(), userRequestedBotView.getUser(),
                    userRequestedBotView.getWidth(), userRequestedBotView.getHeight());
    }

    @Subscribe
    public void onUserJoint(UserJointComplex userJointComplex) {
        Entities.Membership membership = userJointComplex.getMembership();
        Entities.User user = membership.getUser();
        Entities.Complex complex = membership.getComplex();
        Entities.Room hall = complex.getRooms().get(0);
        csmp.createTextMessage(complex.getComplexId(), hall.getRoomId(), "User "
                        + user.getTitle() + "\n" + "welcome to " + complex.getTitle() + " complex"
                , textMessage -> {

                });
    }

    private Controls.Control makeWindow(int width, int height) {
        Controls.PanelCtrl panelCtrl = new Controls.PanelCtrl();
        panelCtrl.setWidth(Controls.Control.MATCH_PARENT);
        panelCtrl.setHeight(Controls.Control.MATCH_PARENT);
        panelCtrl.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        panelCtrl.setControls(new ArrayList<>());
        panelCtrl.setBackColor("#dddddd");

        Controls.PanelCtrl appbar = new Controls.PanelCtrl();
        appbar.setWidth(Controls.Control.MATCH_PARENT);
        appbar.setHeight(56);
        appbar.setBackColor("#0000ff");
        appbar.setElevation(6);
        appbar.setX(0);
        appbar.setY(0);
        appbar.setLayoutType(Controls.PanelCtrl.LayoutType.RELATIVE);
        panelCtrl.getControls().add(appbar);
        appbar.setControls(new ArrayList<>());

        Controls.TextCtrl title = new Controls.TextCtrl();
        title.setX(Controls.Control.CENTER);
        title.setY(Controls.Control.CENTER);
        title.setGravityType(Controls.TextCtrl.GravityType.CENTER);
        title.setTextColor("#ffffff");
        title.setTextSize(23);
        title.setText("Clock");
        appbar.getControls().add(title);

        Controls.PanelCtrl body = new Controls.PanelCtrl();
        body.setLayoutType(Controls.PanelCtrl.LayoutType.LINEAR_VERTICAL);
        body.setControls(new ArrayList<>());

        Controls.ScrollerCtrl scrollerCtrl = new Controls.ScrollerCtrl();
        scrollerCtrl.setWidth(Controls.Control.MATCH_PARENT);
        scrollerCtrl.setHeight(Controls.Control.MATCH_PARENT);
        scrollerCtrl.setPanel(body);
        panelCtrl.getControls().add(scrollerCtrl);

        Controls.Control clock = makeClock(false, 250, 250);
        clock.setX(Controls.Control.CENTER);
        clock.setY(112);
        clock.setElevation(6);
        body.getControls().add(clock);

        for (int i = 0; i < 10; i++) {
            Controls.PanelCtrl box = new Controls.PanelCtrl();
            box.setWidth(Controls.Control.MATCH_PARENT);
            box.setHeight(56);
            box.setMarginLeft(16);
            box.setMarginRight(16);
            if (i == 0) {
                box.setMarginTop(176);
            } else {
                box.setMarginTop(8);
            }
            box.setMarginBottom(8);
            box.setCornerRadius(8);
            box.setElevation(6);
            box.setLayoutType(Controls.PanelCtrl.LayoutType.LINEAR_HORIZONTAL);
            box.setControls(new ArrayList<>());
            body.getControls().add(box);

            Controls.TextCtrl time = new Controls.TextCtrl();
            time.setWidth(width - 96);
            time.setHeight(Controls.Control.MATCH_PARENT);
            time.setTextColor("#000000");
            time.setTextSize(18);
            time.setText("0" + i + ":30");
            time.setGravityType(Controls.TextCtrl.GravityType.LEFT_CENTER_VERTICAL);
            time.setPaddingLeft(32);
            time.setPaddingRight(32);
            box.getControls().add(time);

            Controls.SwitchCtrl switchCtrl = new Controls.SwitchCtrl();
            switchCtrl.setMarginTop(16);
            box.getControls().add(switchCtrl);
        }

        return panelCtrl;
    }

    private void pushInitialHomeViewToClient(boolean windowMode, long complexId, long roomId, Entities.User user, int width, int height) {
        if (windowMode)
            csmp.initBotView(true, complexId, roomId
                    , user.getBaseUserId(), makeWindow(width, height)
                    , () -> { });
        else
            csmp.initBotView(false, complexId, roomId
                    , user.getBaseUserId(), makeClock(false, width, height)
                    , () -> { });
    }
}
