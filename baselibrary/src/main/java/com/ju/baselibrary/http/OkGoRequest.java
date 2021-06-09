package com.ju.baselibrary.http;

import android.content.Context;
import androidx.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class OkGoRequest {
    public static OkGoRequest okGoRequest;
    private Context context;
    private String url;
    private HttpParams params;
    private HttpHeaders headers;
    private OkGoRequest(Context context) {
        this.context = context;
    }
    public static OkGoRequest get(Context context) {
        if(okGoRequest ==null){
            okGoRequest = new OkGoRequest(context);
        }
        return okGoRequest;
    }
    public OkGoRequest url(String url) {
        this.url = url;
        return this;
    }
    /**
     * 传参
     * @param key   键值
     * @param value
     * @return
     */
    public OkGoRequest params(String key, String value) {
        if (params == null) {
            params = new HttpParams();
        }
        if (!TextUtils.isEmpty(value))
            params.put(key, value);
        return this;
    }
    public OkGoRequest params(String key, int value) {
        if (params == null) {
            params = new HttpParams();
        }
        params.put(key, value);
        return this;
    }
    public OkGoRequest params(String key, float value) {
        if (params == null) {
            params = new HttpParams();
        }
        params.put(key, value);
        return this;
    }
    public OkGoRequest params(String key, long value) {
        if (params == null) {
            params = new HttpParams();
        }
        params.put(key, value);
        return this;
    }
    public OkGoRequest params(String key, double value) {
        if (params == null) {
            params = new HttpParams();
        }
        params.put(key, value);
        return this;
    }
    public OkGoRequest params(String key, boolean value) {
        if (params == null) {
            params = new HttpParams();
        }
        params.put(key, value);
        return this;
    }
    public OkGoRequest params(Map<String, String> map) {
        if (params == null) {
            params = new HttpParams();
        }
        params.put(map);
        return this;
    }
    public OkGoRequest params(String key, @NonNull List<File> files) {
        if (params == null) {
            params = new HttpParams();
        }
        params.putFileParams(key,files);
        return this;
    }

    /**
     * get请求 返回 string
     *
     * @param
     * @param mCallBack 回调结果
     */

    public void doGet(final HttpStringCallBack mCallBack) {
        try {
            if (params == null) {
                params = new HttpParams();
            }
            if (headers == null) {
                headers = new HttpHeaders();
            }
            // headers.put("Cookie", aCache.getAsString("cookie"));
            OkGo.<String>get(url).tag(context)
                    .cacheKey(url + params.toString())
                    .params(params).headers(headers).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.onSuccess(body);
                }

                @Override
                public void onCacheSuccess(Response<String> response) {
                    super.onCacheSuccess(response);
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.onSuccess(body);
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    if (mCallBack != null)
                        mCallBack.onFailure(response.code(), "" + response.message());
                }
            });
        } catch (Exception e) {
            mCallBack.onFailure(0, "" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * post 请求 返回string
     *
     * @param mCallBack
     */
    public void doPost(@NonNull final HttpStringCallBack mCallBack) {
        try {
            if (params == null) {
                params = new HttpParams();
            }
            if (headers == null) {
                headers = new HttpHeaders();
            }
            // headers.put("Cookie", aCache.getAsString("cookie"));
            OkGo.<String>post(url).tag(context)
                    .cacheKey(url + params.toString())
                    .params(params).headers(headers).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.onSuccess(body);
                }

                @Override
                public void onCacheSuccess(Response<String> response) {
                    super.onCacheSuccess(response);
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.onSuccess(body);
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    if (mCallBack != null)
                        mCallBack.onFailure(response.code(), "" + response.message());
                }
            });
        } catch (Exception e) {
            mCallBack.onFailure(0, e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * get请求 返回 bean
     * @param
     * @param mCallBack 回调结果
     */

    public <T> void doGet(@NonNull final HttpObjectCallBack<T> mCallBack) {
        try {
            if (params == null) {
                params = new HttpParams();
            }
            if (headers == null) {
                headers = new HttpHeaders();
            }
           // headers.put("Cookie", aCache.getAsString("cookie"));
            OkGo.<String>get(url).tag(context)
                    .cacheKey(url + params.toString())
                    .params(params).headers(headers).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.JsonToBean(body);
                }

                @Override
                public void onCacheSuccess(Response<String> response) {
                    super.onCacheSuccess(response);
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.JsonToBean(body);
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    if (mCallBack != null)
                        mCallBack.onFailure(response.code(), "" + response.message());

                }
            });
        } catch (Exception e) {
            mCallBack.onFailure(0, "" + e.getMessage());
            e.printStackTrace();
        }
    }
    public <T> void doPost(@NonNull final HttpObjectCallBack<T> mCallBack) {
        try {
            if (params == null) {
                params = new HttpParams();
            }
            if (headers == null) {
                headers = new HttpHeaders();
            }
            // headers.put("Cookie", aCache.getAsString("cookie"));
            OkGo.<String>post(url).tag(context)
                    .cacheKey(url + params.toString())
                    .params(params).headers(headers).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.JsonToBean(body);
                }

                @Override
                public void onCacheSuccess(Response<String> response) {
                    super.onCacheSuccess(response);
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.JsonToBean(body);
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    if (mCallBack != null)
                        mCallBack.onFailure(response.code(), "" + response.message());

                }
            });
        } catch (Exception e) {
            mCallBack.onFailure(0, "" + e.getMessage());
            e.printStackTrace();
        }
    }
    private  String body;
    public void doPostWithBody(@NonNull final HttpStringCallBack mCallBack) {
        try {
            if (params == null) {
                params = new HttpParams();
            }
            if (headers == null) {
                headers = new HttpHeaders();
            }
            if (params != null) {
                Map<String, Object> map = new HashMap();
                for (Map.Entry entry : params.urlParamsMap.entrySet()) {
                    try {
                        if (entry.getValue() instanceof List) {
                            map.put(entry.getKey().toString(), ((List) entry.getValue()).get(0));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                body = JSON.toJSONString(map);
            } else {
                body = "";
            }
            // headers.put("Cookie", aCache.getAsString("cookie"));
            headers.put("platform", "caseManager");
            OkGo.<String>post(url).tag(context)
//                    .cacheKey(url + params.toString())

                    .upRequestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body))
                    .params(params).headers(headers).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.onSuccess(body);
                }

                @Override
                public void onCacheSuccess(Response<String> response) {
                    super.onCacheSuccess(response);
                    String body = response.body();
                    if (mCallBack != null)
                        mCallBack.onSuccess(body);
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    if (mCallBack != null)
                        mCallBack.onFailure(response.code(), "" + response.message());
                }
            });
        } catch (Exception e) {
            mCallBack.onFailure(0, e.getMessage());
            e.printStackTrace();
        }
    }
}
