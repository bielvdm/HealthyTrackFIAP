import './App.css';
import logo from './img/unnamed.png'
import React from 'react';
import ReactApexChart from 'react-apexcharts';

function App() {

  const [firstOption, setFirstOption] = React.useState({
    chart: {
      type: 'bar',
      height: 350
    },
    plotOptions: {
      bar: {
        horizontal: false,
        columnWidth: '55%',
        endingShape: 'rounded'
      },
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      show: true,
      width: 2,
      colors: ['transparent']
    },
    xaxis: {
      categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct'],
    },
    yaxis: {
      title: {
        text: '$ (thousands)'
      }
    },
    fill: {
      opacity: 1
    },
    tooltip: {
      y: {
        formatter: function (val) {
          return "$ " + val + " thousands"
        }
      }
    }
  })
  const [firstSerie, setFirstSerie] = React.useState([{
    name: 'Net Profit',
    data: [44, 55, 57, 56, 61, 58, 63, 60, 66]
  }, {
    name: 'Revenue',
    data: [76, 85, 101, 98, 87, 105, 91, 114, 94]
  }, {
    name: 'Free Cash Flow',
    data: [35, 41, 36, 26, 45, 48, 52, 53, 41]
  }])
  const [SecondOption, setSecondOption] = React.useState({
    chart: {
      type: 'bar',
      height: 350
    },
    plotOptions: {
      bar: {
        horizontal: false,
        columnWidth: '55%',
        endingShape: 'rounded'
      },
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      show: true,
      width: 2,
      colors: ['transparent']
    },
    xaxis: {
      categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct'],
    },
    yaxis: {
      title: {
        text: '$ (thousands)'
      }
    },
    fill: {
      opacity: 1
    },
    tooltip: {
      y: {
        formatter: function (val) {
          return "$ " + val + " thousands"
        }
      }
    }
  })
  const [SecondSerie, setSecondSerie] = React.useState([{
    name: 'Net Profit',
    data: [44, 55, 57, 56, 61, 58, 63, 60, 66]
  }, {
    name: 'Revenue',
    data: [76, 85, 101, 98, 87, 105, 91, 114, 94]
  }, {
    name: 'Free Cash Flow',
    data: [35, 41, 36, 26, 45, 48, 52, 53, 41]
  }])

  React.useEffect(() => {
    var options = {
      colors: ['#c2e4ff', '#54a0de', '#b2d97c'],
      chart: {
        type: 'bar',
        height: 350
      },
      plotOptions: {
        bar: {
          horizontal: false,
          columnWidth: '55%',
          endingShape: 'rounded'
        },
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        show: true,
        width: 2,
        colors: ['transparent']
      },
      xaxis: {
        categories: ['Norte', 'Nordeste', 'Sul', 'Sudeste', 'Centro-Oeste'],
      },
      yaxis: {
        title: {
          text: 'Casos'
        }
      },
      fill: {
        opacity: 1
      },
      tooltip: {
        y: {
          formatter: function (val) {
            return val + " casos"
          }
        }
      },
      toolbar: {
        show: false,
        tools: {
          download: false,
          selection: false,
          zoom: false,
          zoomin: false,
          zoomout: false
        },
      }
    };

    var series = [{
      name: 'Zika',
      data: [444, 445, 537, 561, 611]
    }, {
      name: 'Malária',
      data: [746, 585, 101, 938, 827]
    }, {
      name: 'Dengue',
      data: [355, 431, 368, 261, 451]
    }]

    setFirstOption(options)
    setFirstSerie(series)

    var series1 = [{
      name: 'Zika',
      data: [31, 40, 28, 51, 42, 109, 100]
    }, {
      name: 'Malária',
      data: [11, 32, 45, 32, 34, 52, 41]
    }, {
      name: 'Dengue',
      data: [12, 53, 12, 14, 23, 90, 42]
    }]

    var options1 = {
      chart: {
        height: 350,
        type: 'area'
      },
      dataLabels: {
        enabled: false,
        style: {
          colors: ['#A2D5FF', '#1C74BB', '#8AD424']
        }
      },
      stroke: {
        curve: 'smooth'
      },
      xaxis: {
        type: 'text',
        categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct']
      },
      yaxis: {
        title: {
          text: 'Casos'
        }
      },
      tooltip: {
        y: {
          formatter: function (val) {
            return val + " casos"
          }
        }
      },
      toolbar: {
        show: false,
        tools: {
          download: false,
          selection: false,
          zoom: false,
          zoomin: false,
          zoomout: false
        },
      },
      colors: ['#A2D5FF', '#1C74BB', '#8AD424']

    }

    setSecondSerie(series1)
    setSecondOption(options1)

  }, [])

  return (
    <section className='body-dash'>
      <section className='side-bar'>
        <div className='content-side-bar'>
          <img src={logo} alt='logo' />
        </div>
      </section>

      <section className='content-dashboard'>
        <div className='title-dash'>
          <h1>Healthcare</h1>
          <h3>Prevenção da zika, malária e dengue</h3>
        </div>
        <div className='container-graphs'>
          <div className='firstGraph'>
            <ReactApexChart options={SecondOption} series={SecondSerie} type="area" height={'100%'} width={'100%'} />
          </div>
          <div className='secondGraph'>
            <ReactApexChart options={firstOption} series={firstSerie} type="bar" height={'100%'} width={'100%'} />
          </div>
        </div>

        <div className='content-total'>
          <div>
            <h1>Zika</h1>
            <p>12.456 casos</p>
          </div>
          <div>
            <h1>Malária</h1>
            <p>19.456 casos</p>
          </div>
          <div>
            <h1>Dengue</h1>
            <p>9.456 casos</p>
          </div>
        </div>

      </section>
    </section>
  );
}

export default App;
