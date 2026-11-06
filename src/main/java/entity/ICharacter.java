package entity;

import action.Action;
import action.IAction;
import status.StatusList;

import java.util.List;

public interface ICharacter {



        void nextMove(List<ICharacter> characterList);

        Stat getStat();

        void setStat(Stat stat);

        String getName();

        int getCurrentHP();

        void setCurrentHP(int currentHP);

        int getCurrentMP();

        void setCurrentMP(int currentMP);


        StatusList getStatusList();

        void setStatusList(StatusList statusList);

        Stat getTempStat();

        void setTempStat(Stat tempStat);

        List<IAction> getPossibleActions();

        void setPossibleActions(List<IAction> possibleActions);

        void setName(String name);
    }


