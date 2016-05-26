var BarChart, RadarChart, bar, data, line, lineChart, pie, pieChart, pieData, pieOptions, radar;

data = {
  labels: ["January", "February", "March", "April", "May", "June"],
  datasets: [
    {
      fillColor: "rgba(172,194,132,0.4)",
      strokeColor: "#ACC26D",
      pointColor: "#fff",
      pointStrokeColor: "#9DB86D",
      data: [20300, 1560, 9900, 2510, 3050, 23423]
    }
  ]
};

pieData = [
  {
    value: 20,
    color: "#878BB6"
  }, {
    value: 40,
    color: "#4ACAB4"
  }, {
    value: 10,
    color: "#FF8153"
  }, {
    value: 30,
    color: "#FFEA88"
  }
];

pieOptions = {
  segmentShowStroke: false,
  animateScale: true
};

line = document.getElementById('lineChart').getContext('2d');

bar = document.getElementById('barChart').getContext('2d');

radar = document.getElementById('radarChart').getContext('2d');

pie = document.getElementById('pieChart').getContext('2d');

lineChart = new Chart(line).Line(data);

BarChart = new Chart(bar).Bar(data);

RadarChart = new Chart(radar).Radar(data);

pieChart = new Chart(pie).Pie(pieData, pieOptions);
