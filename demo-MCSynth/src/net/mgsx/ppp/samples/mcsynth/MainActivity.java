package net.mgsx.ppp.samples.mcsynth;

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
import net.mgsx.ppp.widget.custom.SimpleBang;
import net.mgsx.ppp.widget.core.Toggle;
import net.mgsx.ppp.widget.custom.FilledToggle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        PdDroidPartyConfig config = new PdDroidPartyConfig();

        config.theme = new MonochromeTheme(0xFF908f8f,  0xFF6b6868, 0xFF2d2b2b);
       
        //config.guiKeepAspectRatio = true;
        
        config.typeOverrides.put(Taplist.class, PopupTaplist.class);
        config.typeOverrides.put(Slider.class, RibbonSlider.class);
        //config.typeOverrides.put(Bang.class, SimpleBang.class);
       // config.typeOverrides.put(Toggle.class, FilledToggle.class);
        
        
       // config.presetsPaths.add("MCSynth/presets_pattern");
       // config.presetsPaths.add("MCSynth/presets_synth");
       
         
        PdDroidPartyLauncher.launch(this,"MCSynth/mcsynth_pannel2.pd",config);
        
    }
    



}
