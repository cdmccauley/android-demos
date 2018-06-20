package tech.mccauley.androidfamousathlete;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import tech.mccauley.androidfamousathlete.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            if (mItem.image != 0) {
                ((ImageView) rootView.findViewById(R.id.item_image)).setImageResource(mItem.image);
            }
            if (!mItem.website) {
                String[] nonResourceString = getResources().getStringArray(mItem.details);
                for (int i = 0; i < nonResourceString.length; i++) {
                    ((TextView)rootView.findViewById(R.id.item_detail)).append(nonResourceString[i]);
                }
                rootView.findViewById(R.id.website_scrollview).setVisibility(View.GONE);
            } else {
                WebView webView = rootView.findViewById(R.id.item_website);

                rootView.findViewById(R.id.item_detail).setVisibility(View.GONE);

                String[] itemDetail = getResources().getStringArray(mItem.details);

                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebChromeClient(new WebChromeClient());
                webView.setWebViewClient(new WebViewClient());

                webView.loadUrl(itemDetail[0]);

                Toast loadingMsg = Toast.makeText(rootView.getContext(), "Loading...", Toast.LENGTH_LONG);
                loadingMsg.setGravity(Gravity.TOP, 0, 150);
                loadingMsg.show();
            }
        }

        return rootView;
    }
}
