package com.example.re_2;

import static com.example.re_2.functions.BitmapConverter.BitmapToByteArray;
import static com.example.re_2.functions.BitmapConverter.BitmapToString;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.re_2.functions.retrofit.ApiService;
import com.example.re_2.functions.retrofit.OutputData;
import com.example.re_2.functions.retrofit.RetrofitClient;
import com.google.android.material.card.MaterialCardView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MenuActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        TextView textView;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        String bitmap_string = "";
        byte[] byteArray = null;

        File storageDir = new File(getFilesDir() + "/capture");
        String filename = "pic" + ".jpg";

        File file = new File(storageDir, filename);
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            bitmap_string = BitmapToString(bitmap);

            // Bitmap을 ByteArray로 변환
            byteArray = BitmapToByteArray(bitmap);
            //


            // Log.v("bitmapp_string=",bitmap_string);
            Log.v("bitmapp_string length:", bitmap_string.length() + "");


            //파일 비트맵 스트링으로 전환하고나서 파일 삭제
            boolean deleted = file.delete();
            //


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        //Retrofit Post설정
        RequestBody requestBody = RequestBody.create(byteArray, MediaType.parse("image/png"));
        MultipartBody.Part imagePart = MultipartBody.Part.createFormData("image", "sample_image.png", requestBody);

        // Retrofit 호출
        ApiService apiService = RetrofitClient.getApiService();
        apiService.uploadBitmap(imagePart).enqueue(new Callback<List<OutputData>>() {
            @Override
            public void onResponse(Call<List<OutputData>> call, Response<List<OutputData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    displayCards(response.body(), null); // 성공 시 데이터 전달
                } else {
                    displayCards(null, response.code()); // 실패 시 HTTP 상태 코드 전달
                }

            }

            @Override
            public void onFailure(Call<List<OutputData>> call, Throwable t) {
                t.printStackTrace();
                displayCards(null, -1);
            }
        });


        //


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    private void displayCards(List<OutputData> outputDataList, Integer errorCode) {
        LinearLayout layout = findViewById(R.id.card_container);
        TextView errorTextView = findViewById(R.id.error_message);

        // 네트워크 오류 발생 시 처리
        if (errorCode != null) {
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText(String.format("서버와 통신 중 오류가 발생했습니다. (에러 코드: %d)", errorCode));

            layout.removeAllViews(); // 기존 카드 제거
            return;
        }

        // 데이터를 받아오지 못한 경우 처리
        if (outputDataList == null || outputDataList.isEmpty()) {
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText("서버와 통신할 수 없습니다.");
            layout.removeAllViews(); // 기존 카드 제거
            return;
        }

        // 에러 메시지 숨기기
        errorTextView.setVisibility(View.GONE);

        // 데이터를 받아온 경우 카드 생성
        for (OutputData data : outputDataList) {
            // 카드뷰 생성
            MaterialCardView cardView = new MaterialCardView(this);
            cardView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            cardView.setCardElevation(8);
            cardView.setContentPadding(16, 16, 16, 16);
            cardView.setRadius(16);
            cardView.setUseCompatPadding(true);


            // 카드 내부 레이아웃
            LinearLayout cardLayout = new LinearLayout(this);
            cardLayout.setOrientation(LinearLayout.VERTICAL);
            cardLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            // 메뉴 정보 텍스트뷰
            TextView textView = new TextView(this);
            textView.setText(String.format("추천메뉴: %s\n\n%s", data.getMenu(), data.getSentence()));
            textView.setTextSize(18);
            textView.setPadding(0, 0, 0, 16);

            // 주문하기 버튼
            Button orderButton = new Button(this);
            orderButton.setText("주문하기");
            orderButton.setOnClickListener(v -> {
                // 주문 버튼 클릭 시 이벤트
                Toast.makeText(this, data.getMenu() + " 주문되었습니다!", Toast.LENGTH_SHORT).show();
            });

            // 카드 레이아웃에 텍스트와 버튼 추가
            cardLayout.addView(textView);
            cardLayout.addView(orderButton);

            // 카드뷰에 레이아웃 추가
            cardView.addView(cardLayout);

            // 카드뷰를 메인 레이아웃에 추가
            layout.addView(cardView);
        }
    }
}

