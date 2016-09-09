package net.mgsx.ppp.samples.loopersynth;

import android.app.Activity;
import android.os.Bundle;
import net.mgsx.ppp.PdDroidPartyConfig;
import net.mgsx.ppp.PdDroidPartyLauncher;
import net.mgsx.ppp.theme.mono.MonochromeTheme;
import net.mgsx.ppp.widget.abs.Taplist;
import net.mgsx.ppp.widget.custom.PopupTaplist;
import net.mgsx.ppp.widget.core.Slider;
import net.mgsx.ppp.widget.custom.RibbonSlider;
import net.mgsx.ppp.widget.core.Bang;
import net.mgsx.ppp.widget.core.Radio;
import net.mgsx.ppp.widget.custom.SimpleBang;
import net.mgsx.ppp.widget.core.Toggle;
import net.mgsx.ppp.widget.custom.SimpleRadio;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        PdDroidPartyConfig config = new PdDroidPartyConfig();

        config.theme = new MonochromeTheme(0xFF272308,  0xFF333220, 0xFFFBCB4B);
       
        //config.guiKeepAspectRatio = true;
        
        config.typeOverrides.put(Taplist.class, PopupTaplist.class);
        config.typeOverrides.put(Slider.class, RibbonSlider.class);
        config.typeOverrides.put(Bang.class, SimpleBang.class);
        config.typeOverrides.put(Toggle.class, HexToggle.class);
        config.typeOverrides.put(Radio.class, SimpleRadio.class);
        
        
        
        config.guiPatches.put("Keyboard1", "LooperSynth/loopersynth_pannel1.pd");
        config.guiPatches.put("Keyboard2", "LooperSynth/loopersynth_pannel2.pd");
        config.guiPatches.put("Controls", "LooperSynth/loopersynth_synthcontrols.pd");
        config.corePatches.add("LooperSynth/loopersynth_audiocore.pd");
        
        config.presetsPaths.add("LooperSynth/presets");
       
       
         
        PdDroidPartyLauncher.launch(this, config);
    }
    



}
