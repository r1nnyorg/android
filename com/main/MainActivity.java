package com.main;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final var webView = new android.webkit.WebView(this);
        webView.loadUrl("file:///android_asset/index.html");
        super.setContentView(webView);
        final var p2pclient = new java.io.File(super.getFilesDir(), "p2pclient");
        try
        {
        java.nio.file.Files.copy(super.getAssets().open("p2pclient"), p2pclient.toPath());
        p2pclient.setExecutable(true);
        //final var process = new java.lang.ProcessBuilder(p2pclientPath.toString(), "-l", "chaowen.guo1@gmail.com", "-n", ";8.8.8.8,4.4.4.4").start();
        final var process = new java.lang.ProcessBuilder("ndk-depends", p2pclient.getPath()).start();
        //final var button = new android.widget.Button(this);
        java.lang.System.out.println(new java.lang.String(process.getInputStream().readAllBytes()));
        //super.setContentView(button);
        //java.lang.System.out.println(p2pclient.length());
        }
        catch (final java.lang.Exception e){java.lang.System.out.println(e);}
    }  
}
