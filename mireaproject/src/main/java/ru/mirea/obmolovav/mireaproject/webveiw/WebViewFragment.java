package ru.mirea.obmolovav.mireaproject.webveiw;  // ✅ ВАЖНО: точный пакет!

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import ru.mirea.obmolovav.mireaproject.R;

public class WebViewFragment extends Fragment {

    private WebView webView;
    private static final String DEFAULT_URL = "https://developer.android.com";

    public WebViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_webview, container, false);

        webView = root.findViewById(R.id.webView);
        EditText etUrl = root.findViewById(R.id.etUrl);
        Button btnGo = root.findViewById(R.id.btnGo);
        ProgressBar progressBar = root.findViewById(R.id.progressBar);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                etUrl.setText(url);
            }
        });

        webView.setWebChromeClient(new android.webkit.WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setVisibility(progress < 100 ? View.VISIBLE : View.GONE);
                progressBar.setProgress(progress);
            }
        });

        // Обработка кнопки Go
        btnGo.setOnClickListener(v -> {
            String url = etUrl.getText().toString().trim();
            if (!url.isEmpty() && !url.startsWith("http")) {
                url = "https://" + url;
            }
            if (!url.isEmpty()) {
                webView.loadUrl(url);
            }
        });

        etUrl.setOnEditorActionListener((v, actionId, event) -> {
            btnGo.performClick();
            return true;
        });

        webView.loadUrl(DEFAULT_URL);
        etUrl.setText(DEFAULT_URL);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (webView != null) {
            webView.destroy();
        }
    }
}