package mx.com.dloza.descendent;

import android.content.Intent;
import android.content.pm.FeatureGroupInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.squareup.picasso.Picasso;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import mx.com.dloza.descendent.adapter.GalleryAdapter;
import mx.com.dloza.descendent.common.Common;
import mx.com.dloza.descendent.model.Gallery;

public class GalleryActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    GalleryAdapter galleryAdapter;
    TextSwitcher mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //create data first
        initData();
        galleryAdapter = new GalleryAdapter(Common.galleryList,this);
        coverFlow = findViewById(R.id.cover_flow);
        mTitle = findViewById(R.id.m_title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(GalleryActivity.this);
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow.setAdapter(galleryAdapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.galleryList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GalleryActivity.this,GalleryDetail.class);
                intent.putExtra("gallery_index",i);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        //summary data you can get from idmb
        /*Gallery gallery = new Gallery("Miguel Hidalgo", "https://78.media.tumblr.com/7d51d6ab549daf475e8cc87cada9fafa/tumblr_p5ecw4o7ZQ1x8mzzro1_1280.jpg",
                "Descripcion de la pintura...");
        Common.galleryList.add(gallery);

        gallery = new Gallery("Cura Hidalgo", "https://78.media.tumblr.com/ff6e465fafed8725272c886b484fa35a/tumblr_p5ed46QcHq1x8mzzro1_1280.jpg",
                "Peque;a descripcion con la que cuentan las pinturas");
        Common.galleryList.add(gallery);

        gallery = new Gallery("Se;ora no se como se llame", "https://78.media.tumblr.com/f4c276647e206839a7cd26ff178abb74/tumblr_p5ed46QcHq1x8mzzro2_1280.jpg",
                "With many people...");
        Common.galleryList.add(gallery);

        gallery = new Gallery("Miguel Hidalgo y Costilla", "https://78.media.tumblr.com/862515c954b5c32fc43f1799b64ecdc7/tumblr_p5ed46QcHq1x8mzzro3_1280.jpg",
                "Cura Hidalgo con el estandarte");
        Common.galleryList.add(gallery);

        gallery = new Gallery("Pintura de la Independencia", "https://78.media.tumblr.com/862515c954b5c32fc43f1799b64ecdc7/tumblr_p5ed46QcHq1x8mzzro3_1280.jpg",
                "descripcion de la pintura");
        Common.galleryList.add(gallery);*/

        //let do same with all gallery you want
        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_1), getString(R.string.url_gallery_1),
                getString(R.string.description_gallery_1)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_2), getString(R.string.url_gallery_2),
                getString(R.string.description_gallery_2)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_3), getString(R.string.url_gallery_3),
                getString(R.string.description_gallery_3)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_4), getString(R.string.url_gallery_4),
                getString(R.string.description_gallery_4)));

        Common.galleryList.add(new Gallery(getString(R.string.title_gallery_5), getString(R.string.url_gallery_5),
                getString(R.string.description_gallery_5)));


    }
}
