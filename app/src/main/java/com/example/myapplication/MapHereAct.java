package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.standard.LoadingDialog;
import com.example.myapplication.standard.LoadingView;
import com.here.android.mpa.common.*;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapRoute;
import com.here.android.mpa.mapping.SupportMapFragment;
import com.here.android.mpa.routing.*;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapHereAct extends AppCompatActivity {

    private LoadingView dialog;

    Map map;
    private boolean paused = false;
    private double mediumZoom;
    List<MapRoute> routes = new ArrayList<>();
    List<MapRoute> routes1 = new ArrayList<>();
    RoutePlan routePlan5;
    RouteManager rm6;


    GeoCoordinate basePoint;
    RoutePlan routePlan6;
    RouteManager rm7;
     RoutePlan routePlan7;
     RouteManager rm8;
    private RouteManager rm9;
    private RoutePlan routePlan8;
    private RouteManager rm10;
    private RoutePlan routePlan9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePoint = new GeoCoordinate(59.9690552, 30.3151436);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.map_fragment);
        dialog = LoadingDialog.view(getSupportFragmentManager());
        // Search for the Map Fragment
        final SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapfragment);
        // initialize the Map Fragment and
        // retrieve the map that is associated to the fragment
        mapFragment.init(new OnEngineInitListener() {
            @Override
            public void onEngineInitializationCompleted(
                    OnEngineInitListener.Error error) {
                if (error == OnEngineInitListener.Error.NONE) {
                    // now the map is ready to be used
                    map = mapFragment.getMap();
                    PositioningManager.getInstance().start(PositioningManager.LocationMethod.GPS_NETWORK);
                    map.getPositionIndicator().setVisible(true);
                    map.setCenter(new GeoCoordinate(59.9690552, 30.3151436), Map.Animation.NONE);
                    map.setZoomLevel(map.getMaxZoomLevel() - 6);

//                    Image image = null;
//
//                    try {
//                        image = new Image();
//                        image.setImageResource(R.drawable.vertica);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    MapMarker mapMarker = new MapMarker(basePoint, image);
//                    MapMarker mapMarker1 = new MapMarker(new GeoCoordinate(59.968864, 30.311801
//                    ), image);
//                    MapMarker mapMarker2 = new MapMarker(new GeoCoordinate(59.973213, 30.319788), image);


                    //
                    // ...
                } else {
                    System.out.println("ERROR: Cannot initialize SupportMapFragment");
                }


            }
        });


        // Register positioning listener
        PositioningManager.getInstance().addListener(
                new WeakReference<>(positionListener));

        // Declare the rm variable (the RouteManager)
        RouteManager rm1 = new RouteManager();
        RouteManager rm2 = new RouteManager();
        RouteManager rm3 = new RouteManager();
        RouteManager rm4 = new RouteManager();
        RouteManager rm5 = new RouteManager();
        rm6 = new RouteManager();
        rm7 = new RouteManager();
        rm8 = new RouteManager();
        rm9 = new RouteManager();
        rm10 = new RouteManager();

        // Create the RoutePlan and add two waypoints
        RoutePlan routePlan = new RoutePlan();
        RoutePlan routePlan1 = new RoutePlan();
        RoutePlan routePlan2 = new RoutePlan();
        RoutePlan routePlan3 = new RoutePlan();
        RoutePlan routePlan4 = new RoutePlan();
        routePlan5 = new RoutePlan();
        routePlan6 = new RoutePlan();
        routePlan7 = new RoutePlan();
        routePlan8 = new RoutePlan();
        routePlan9 = new RoutePlan();
//        routePlan.addWaypoint(new GeoCoordinate(49.1966286, -123.0053635));
//        routePlan.addWaypoint(new GeoCoordinate(49.1947289, -123.1762924));
        //
        routePlan.addWaypoint(basePoint);
        routePlan1.addWaypoint(basePoint);
        routePlan2.addWaypoint(basePoint);
        routePlan3.addWaypoint(basePoint);
        routePlan4.addWaypoint(basePoint);
        routePlan6.addWaypoint(new GeoCoordinate(59.981816, 30.325511));
        routePlan7.addWaypoint(new GeoCoordinate(59.989164, 30.310410));
        routePlan8.addWaypoint(new GeoCoordinate(59.999687, 30.329548));
        routePlan9.addWaypoint(new GeoCoordinate(60.005990, 30.333470
        ));

//        routePlan.addWaypoint(new GeoCoordinate(59.973213, 30.319788));


        routePlan.addWaypoint(new GeoCoordinate(59.972735, 30.314810));
        routePlan1.addWaypoint(new GeoCoordinate(59.973213, 30.319788));
        routePlan2.addWaypoint(new GeoCoordinate(59.968472, 30.309671
        ));
        routePlan3.addWaypoint(new GeoCoordinate(59.968781, 30.306420
        ));
        routePlan4.addWaypoint(new GeoCoordinate(59.968864, 30.311801
        ));

        routePlan5.addWaypoint(new GeoCoordinate(59.981816, 30.325511
        ));
        routePlan6.addWaypoint(new GeoCoordinate(59.989164, 30.310410
        ));
        routePlan7.addWaypoint(new GeoCoordinate(59.999687, 30.329548
        ));
        routePlan8.addWaypoint(new GeoCoordinate(60.005990, 30.333470
        ));
        routePlan9.addWaypoint(new GeoCoordinate(60.017881, 30.366580
        ));

        RouteOptions routeOptions = new RouteOptions();
        routeOptions.setTransportMode(RouteOptions.TransportMode.CAR);
        routeOptions.setRouteType(RouteOptions.Type.FASTEST);

        routePlan.setRouteOptions(routeOptions);
        routePlan1.setRouteOptions(routeOptions);
        routePlan2.setRouteOptions(routeOptions);
        routePlan3.setRouteOptions(routeOptions);
        routePlan4.setRouteOptions(routeOptions);
        routePlan5.setRouteOptions(routeOptions);
        routePlan6.setRouteOptions(routeOptions);
        routePlan7.setRouteOptions(routeOptions);
        routePlan8.setRouteOptions(routeOptions);
        routePlan9.setRouteOptions(routeOptions);

        rm1.calculateRoute(routePlan, new RouteListener());
//        rm.calculateRoute(routePlan1, new RouteListener());
        rm2.calculateRoute(routePlan1, new RouteListener());
        rm3.calculateRoute(routePlan2, new RouteListener());
        rm4.calculateRoute(routePlan3, new RouteListener());
        rm5.calculateRoute(routePlan4, new RouteListener());

//        final RouteTta ttaExcluding = m_route.getTtaExcludingTraffic(Route.WHOLE_ROUTE);
//        final RouteTta ttaIncluding = m_route.getTtaIncludingTraffic(Route.WHOLE_ROUTE);


        MapRoute route = new MapRoute();


//        route.setRoute()
//        route.setRenderType()


    }


    private PositioningManager.OnPositionChangedListener positionListener = new
            PositioningManager.OnPositionChangedListener() {

                @Override
                public void onPositionUpdated(PositioningManager.LocationMethod method,
                                              GeoPosition position, boolean isMapMatched) {
                    // set the center only when the app is in the foreground
                    // to reduce CPU consumption
                    if (!paused) {
                        map.setCenter(position.getCoordinate(),
                                Map.Animation.NONE);
                    }
                }

                public void onPositionFixChanged(PositioningManager.LocationMethod method,
                                                 PositioningManager.LocationStatus status) {


                }
            };

    public int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public void onCalcClick(View view) {
        routes1.addAll(routes);
        Button button = (Button) view;
        switch (button.getText().toString()) {
            case "ПОГРУЗКА ЗАВЕРШЕНА":
                Toast.makeText(MapHereAct.this, "ЗАБЕРИТЕ ДОПОЛНИТЕЛЬНЫЕ ЗАКАЗЫ ПО ПУТИ СЛЕДОВАНИЯ", Toast.LENGTH_LONG).show();
                button.setText("ДОП.ПОГРУЗКА 1 ЗАВЕРШЕНА");
                MapRoute route = routes.get(routes.size()-1);
                GeoCoordinate coordinate = route.getRoute().getDestination();
                routePlan5.addWaypoint(coordinate);
                rm6.calculateRoute(routePlan5, new RouteListener());
                break;
            case "НАЧАТЬ":
                button.setText("ПОГРУЗКА ЗАВЕРШЕНА");
                break;
            case "ДОП.ПОГРУЗКА 2 ЗАВЕРШЕНА":
                Toast.makeText(MapHereAct.this, "ЗАВЕРШИТЕ 1 ЗАКАЗ", Toast.LENGTH_LONG).show();
                button.setText("1 ЗАКАЗ ЗАВЕРШЕН");
                rm8.calculateRoute(routePlan7, new RouteListener());
                break;
            case "1 ЗАКАЗ ЗАВЕРШЕН":
                Toast.makeText(MapHereAct.this, "ЗАВЕРИШИТЕ ДОП.ЗАКАЗЫ", Toast.LENGTH_LONG).show();
                button.setText("1 ДОП.ЗАКАЗ ЗАВЕРШЕН");
                rm9.calculateRoute(routePlan8, new RouteListener());
                break;
            case "1 ДОП.ЗАКАЗ ЗАВЕРШЕН":
                Toast.makeText(MapHereAct.this, "ЗАВЕРШИТЕ 2 ДОП.ЗАКАЗ", Toast.LENGTH_LONG).show();
                button.setText("2 ДОП.ЗАКАЗ ЗАВЕРШЕН");
                rm10.calculateRoute(routePlan9, new RouteListener());
                break;
            case "2 ДОП.ЗАКАЗ ЗАВЕРШЕН":
                Toast.makeText(MapHereAct.this, "ВЫ ВЫПОЛНИЛИ ВСЕ ДОСТУПНЫЕ ЗАКАЗЫ", Toast.LENGTH_LONG).show();
                button.setText("ЗАВЕРШИТЬ");
                break;
            case "ЗАВЕРШИТЬ":
                finish();
                break;
            case "ДОП.ПОГРУЗКА 1 ЗАВЕРШЕНА":
                button.setText("ДОП.ПОГРУЗКА 2 ЗАВЕРШЕНА");
                Toast.makeText(MapHereAct.this, "ЗАБЕРИТЕ 2 ДОП.ЗАКАЗ", Toast.LENGTH_LONG).show();
                rm7.calculateRoute(routePlan6, new RouteListener());
                break;
            default:
                for (int i = 0; i < routes.size() - 1; i++) {
                    MapRoute route1 = routes.get(i);
                    map.removeMapObject(route1);
                    map.setZoomLevel(map.getMaxZoomLevel() - 6, Map.Animation.LINEAR);
                }
                button.setText("НАЧАТЬ");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class RouteListener implements RouteManager.Listener {

        // Method defined in Listener
        public void onProgress(int percentage) {
            // Display a message indicating calculation progress
            dialog.showLoadingIndicator();
        }

        // Method defined in Listener
        public void onCalculateRouteFinished(RouteManager.Error error, List<RouteResult> routeResult) {
            // If the route was calculated successfully
            if (error == RouteManager.Error.NONE) {
                dialog.hideLoadingIndicator();
                // Render the route on the map
                MapRoute mapRoute = new MapRoute(routeResult.get(0).getRoute());
                routes.add(mapRoute);
                mapRoute.setColor(getRandomColor());
                map.addMapObject(mapRoute);
            } else {
                dialog.hideLoadingIndicator();

                // Display a message indicating route calculation failure
            }
        }
    }

//    private void calculateRoute() {
//        /* Initialize a CoreRouter */
//        m_coreRouter = new CoreRouter();
//
//        /* For calculating traffic on the m_route */
//        DynamicPenalty dynamicPenalty = new DynamicPenalty();
//        dynamicPenalty.setTrafficPenaltyMode(Route.TrafficPenaltyMode.OPTIMAL);
//        m_coreRouter.setDynamicPenalty(dynamicPenalty);
//
//        final RoutePlan routePlan = RouteUtil.createRoute();
//
//        m_coreRouter.calculateRoute(routePlan,
//                new RouteUtil.RouteListener<List<RouteResult>, RoutingError>() {
//                    @Override
//                    public void onCalculateRouteFinished(List<RouteResult> routeResults,
//                                                         RoutingError routingError) {
//                        /* Calculation is done. Let's handle the result */
//                        if (routingError == RoutingError.NONE) {
//                            /* Get route fro results */
//                            m_route = routeResults.get(0).getRoute();
//
//                            /* check if map route is already on map and if it is,
//                                delete it.
//                             */
//                            if (m_mapRoute != null) {
//                                m_map.removeMapObject(m_mapRoute);
//                            }
//
//                            /* Create a MapRoute so that it can be placed on the map */
//                            m_mapRoute = new MapRoute(routeResults.get(0).getRoute());
//
//                            /* Add the MapRoute to the map */
//                            m_map.addMapObject(m_mapRoute);
//
//                            /*
//                             * We may also want to make sure the map view is orientated properly so
//                             * the entire route can be easily seen.
//                             */
//                            m_map.zoomTo(m_route.getBoundingBox(), Map.Animation.NONE, 15);
//
//                            /* Get TTA */
//                            calculateTta();
//                            calculateTtaUsingDownloadedTraffic();
//                        } else {
//                            Toast.makeText(getApplicationContext(), routingError.name(),
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }


}
