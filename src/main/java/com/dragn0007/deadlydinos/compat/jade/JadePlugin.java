package com.dragn0007.deadlydinos.compat.jade;

import com.dragn0007.deadlydinos.compat.jade.gender.DinoGenderTooltip;
import com.dragn0007.deadlydinos.compat.jade.gender.MountDinoGenderTooltip;
import com.dragn0007.deadlydinos.compat.jade.gender.TamableDinoGenderTooltip;
import com.dragn0007.deadlydinos.entities.AbstractDino;
import com.dragn0007.deadlydinos.entities.AbstractDinoMount;
import com.dragn0007.deadlydinos.entities.AbstractTamableDino;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(new DinoGenderTooltip(), AbstractDino.class);
        registration.registerEntityComponent(new TamableDinoGenderTooltip(), AbstractTamableDino.class);
        registration.registerEntityComponent(new MountDinoGenderTooltip(), AbstractDinoMount.class);
    }
}
